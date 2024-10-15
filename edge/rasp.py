from flask import Flask, request, jsonify
import time
import json
import os
import random
import paho.mqtt.client as mqtt
import logging

# Initialize Flask app
app = Flask(__name__)

# Configuration File
CONFIG_FILE = 'car-config.json'
FAILED_PAYLOADS_FILE = 'failed_payloads.json'
LOG_FILE = 'car_data.log'

# MQTT settings
MQTT_BROKER = '172.20.0.3'
MQTT_PORT = 1883
MQTT_TOPIC = 'car/'

# VPN settings (Assuming you're using ProtonVPN)
VPN_USER = 'your_vpn_username'
VPN_PASS = 'your_vpn_password'

# Configure logging
logging.basicConfig(filename=LOG_FILE, level=logging.INFO,
                    format='%(asctime)s %(levelname)s:%(message)s')

# Function to establish VPN connection
def connect_vpn():
    os.system(f'vpn-client --connect --user {VPN_USER} --password {VPN_PASS}')
    logging.info('VPN connection established')

# Function to add the car ID to the data
def add_car_id(data):
    with open(CONFIG_FILE) as f:
        car_id = json.load(f)
        data['car_id'] = car_id['id']
    return data

# Function to publish data to MQTT broker
def publish_data(data):
    car_id = data['car_id']
    client = mqtt.Client()
    client.connect(MQTT_BROKER, MQTT_PORT, 60)
    client.publish(MQTT_TOPIC + car_id, json.dumps(data))
    client.disconnect()
    logging.info('Data published to MQTT broker')

# Function to save failed payloads to a local file
def save_failed_payload(data):
    if os.path.exists(FAILED_PAYLOADS_FILE):
        with open(FAILED_PAYLOADS_FILE, 'r') as f:
            failed_payloads = json.load(f)
    else:
        failed_payloads = []

    failed_payloads.append(data)
    
    with open(FAILED_PAYLOADS_FILE, 'w') as f:
        json.dump(failed_payloads, f, indent=4)
    
    logging.warning('Failed payload saved locally')

# Function to send all stored payloads
def resend_failed_payloads():
    if os.path.exists(FAILED_PAYLOADS_FILE):
        with open(FAILED_PAYLOADS_FILE, 'r') as f:
            failed_payloads = json.load(f)
        
        for payload in failed_payloads:
            try:
                publish_data(payload)
            except Exception as e:
                logging.error(f"Error resending payload: {e}")
                return False
        
        # If all payloads were sent successfully, remove the file
        os.remove(FAILED_PAYLOADS_FILE)
        logging.info('All failed payloads resent successfully')
        return True
    
    return False

# Function to clean and prepare data for publishing
def clean_data(data):
    # Clean and format data, provide defaults for missing values
    cleaned_data = {
        'timestamp': data.get('timestamp', time.strftime("%Y-%m-%d %H:%M:%S")),
        'vehicle_speed': data.get('vehicle_speed', 0.0),
        'engine_rpm': data.get('engine_rpm', 0.0),
        'throttle_pos': data.get('throttle_pos', 0.0),
        'battery_voltage': data.get('battery_voltage', 0.0),
        'transmission_temperature': data.get('transmission_temperature', 0.0),
        'oil_temperature': data.get('oil_temperature', 0.0),
        'oil_pressure': data.get('oil_pressure', 0.0),
        'fuel_level': data.get('fuel_level', 0.0),
        'fuel_consumption_rate': data.get('fuel_consumption_rate', 0.0),
        'latitude': round(random.uniform(-90.0, 90.0), 6),
        'longitude': round(random.uniform(-180.0, 180.0), 6)
    }
    # Add the ID of the car retrieved from the json file in the edge device
    cleaned_data = add_car_id(cleaned_data)

    return cleaned_data

# Route to handle incoming OBD data
@app.route('/api/obd-data', methods=['POST'])
def obd_data():
    try:
        # Get the raw data from the request
        raw_data = request.json
        logging.info(f"Received OBD data: {raw_data}")
        
        # Clean the data
        cleaned_data = clean_data(raw_data)
        
        # Resend any failed payloads before sending new data
        resend_failed_payloads()

        # Publish data to MQTT broker
        try:
            publish_data(cleaned_data)
        except Exception as e:
            logging.error(f"Error sending data to MQTT broker: {e}")
            save_failed_payload(cleaned_data)
            return jsonify({"status": "error", "message": "Failed to send data to MQTT broker, saved locally"}), 500

        # Respond with a success message
        return jsonify({"status": "success", "message": "Data received"}), 200
    except Exception as e:
        # Handle any exceptions and respond with an error message
        logging.error(f"Error processing data: {e}")
        return jsonify({"status": "error", "message": str(e)}), 500

# Run the Flask app
if __name__ == '__main__':
    # Connect to VPN on startup
    # connect_vpn()
    # The server will listen on all available IP addresses (0.0.0.0) and port 5000
    app.run(host='0.0.0.0', port=5000)

import time
import json
import os
import random
import paho.mqtt.client as mqtt
import logging
import pandas as pd

# Configuration File
CONFIG_FILE = 'car-config.json'
FAILED_PAYLOADS_FILE = 'failed_payloads.json'
LOG_FILE = 'car_data.log'

# MQTT settings
MQTT_BROKER = "127.0.0.1"
MQTT_PORT = 1883
MQTT_TOPIC = 'car/'

# Configure logging
logging.basicConfig(filename=LOG_FILE, level=logging.INFO,
                    format='%(asctime)s %(levelname)s:%(message)s')

# Function to add the car ID to the data
def add_car_id(data):
    with open(CONFIG_FILE) as f:
        car_id = json.load(f)
        data['car_id'] = car_id['id']
    return data

def add_gps_data(data):
    lat, lon = gps_data 
    data['latitude'] = None if lat <= -90 else lat
    data['longitude'] = None if lon <= -180 else lon
    return data

# Function to publish data to MQTT broker
def publish_data(data):
    carId = data['car_id']
    client = mqtt.Client()
    client.connect(MQTT_BROKER, MQTT_PORT, 60)
    client.publish(MQTT_TOPIC + carId, json.dumps(data))
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

# Function for reading coordinates from a file and returning one at a time at each call
def coordinate_generator(file_path):
    df = pd.read_excel(file_path)
    for _, row in df.iterrows():
        yield row['Latitude'], row['Longitude']

# Class for handling GPS simulation like it was a service
class GPS_Simulator:
    def __init__(self, file_path):
        self.file_path = file_path
        self.generator = coordinate_generator(file_path)
    
    def get_gps_position(self):
        try:
            return next(self.generator)
        except StopIteration:
            # Reinitialize the generator to restart from the beginning
            self.generator = coordinate_generator(self.file_path)
            return next(self.generator)

# Simulate OBD data
def simulate_obd_data():
    current_time = time.time()
    formatted_time = time.strftime("%Y-%m-%d %H:%M:%S", time.gmtime(current_time))
    data = {
        'timestamp': formatted_time,
        "dtc": "P0101, P0420, P0455",
        'throttle_pos': random.randint(0, 100),
        "engine_rpm": random.randint(1000, 5000),
        "vehicle_speed": random.randint(0, 100),
        "battery_voltage": random.uniform(11.5, 14.5),
        "transmission_temperature": random.randint(50, 150),
        "oil_temperature": random.randint(50, 150),
        "oil_pressure": random.randint(10, 100),
        "fuel_level": random.uniform(0, 100),
        "fuel_consumption_rate": random.uniform(0, 100)
    }
    return data

# Starting main code:

# Initialize the generator
simulator = GPS_Simulator('percorso_genova.xlsx')

while True:
    resend_failed_payloads()
    obd_data = simulate_obd_data()
    gps_data = simulator.get_gps_position()
    
    add_car_id(obd_data)
    add_gps_data(obd_data)
    
    try:
        publish_data(obd_data)
        logging.info('Data sent to MQTT broker')
    except Exception as e:
        logging.error(f'Error sending data to MQTT broker: {e}')
        save_failed_payload(obd_data)

    time.sleep(2)

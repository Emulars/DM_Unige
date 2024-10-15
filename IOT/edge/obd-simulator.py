import random
import json
import time
import requests

# Simulate OBD data
def simulate_obd_data():
    data = {
        "dtc": "P0101, P0420, P0455",
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

# Send data to Raspberry Pi
def send_data(data):
    url = "http://127.0.0.1:5000/api/obd-data"  # Replace with your Raspberry Pi's IP address
    headers = {"Content-Type": "application/json"}
    try:
        response = requests.post(url, data=json.dumps(data), headers=headers)
        response.raise_for_status()  # Raise an exception for HTTP errors
        print("Data sent successfully!")
    except requests.exceptions.RequestException as e:
        print(f"Failed to send data: {e}")
        if response:
            print(f"Response status code: {response.status_code}")
            print(f"Response text: {response.text}")

# Main loop
while True:
    obd_data = simulate_obd_data()
    send_data(obd_data)
    time.sleep(60)  # Adjust the delay between data transmissions as needed

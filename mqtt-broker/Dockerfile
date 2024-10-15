# Use an official Eclipse Mosquitto image as the base image
FROM eclipse-mosquitto:latest

# Copy custom configuration file to the container
COPY mosquitto.conf /mosquitto/config/mosquitto.conf

# Expose the default MQTT port and the WebSockets port
EXPOSE 1883 9001

# Set the default command to run Mosquitto
CMD ["mosquitto", "-c", "/mosquitto/config/mosquitto.conf"]

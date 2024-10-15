# Use a base image that emulates ARM architecture
FROM balenalib/rpi-python

# Set the working directory inside the container
WORKDIR /app

# Copy the script file and requirements.txt into the container
COPY rasp.py /app/
COPY required-packages.txt /app/
COPY car-config.json /app/

# Install dependencies
RUN apt-get update && apt-get install build-essential unixodbc-dev -y
RUN pip install --progress-bar=on \paho-mqtt \Flask

# Expose the port on which the Flask server will run (5000)
EXPOSE 5000

# Command to run the Flask server
CMD ["python", "rasp.py"]
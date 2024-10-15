# Use the official Node-RED Docker image as the base image
FROM nodered/node-red:latest

# Copy Node-RED flow configuration file to the container
COPY flows.json /data/flows.json

# Install necessary Node-RED nodes
RUN npm install \
    node-red-contrib-mqtt-broker \
    node-red-contrib-telegrambot \
    node-red-contrib-mssql-plus

# Expose the port that Node-RED listens on
EXPOSE 1880

# Set the default command to run Node-RED
CMD ["npm", "start", "--", "--userDir", "/data"]

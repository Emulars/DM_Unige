# IOT-FinalProject2324

## Docker-compose
Run the following command from the project root directory to start all the servce with the specified static IP address
```bash
docker-compose up
```

In the Middleware container connect to the node-red flow to add the Telegram Token and Database Username and Password

## Edge Device

***Fallback Mechanism***: If the mqtt message fails, the data is saved to a JSON file. The script attempts to resend any unsent data when the connection becomes available again.

Before the build check the ***MQTT Settings*** in the rasp.py file

Build the docker image
```bash
docker build -t edge-device .
```

Once the image is built, you can run the container with:
```bash
docker run -d -p 5000:5000 --name edge-device edge-device
```

Access the container to check the result
```bash
docker exec -it edge-device /bin/bash
```

## Middleware

Inside the mqtt-broker folder, you will find the Dockerfile for the mosquitto broker

Check the database and broker configuration in the node-red flow

Build the docker image
```bash
docker build -t my-mosquitto-broker .
```

Once the image is built, you can run the container with:
```bash
docker run -it -p 1883:1883 -p 9001:9001 --name mosquitto-broker my-mosquitto-broker

```

Inside the middleware folder, you will find the Dockerfile and the Node-RED flow.

Build the docker image
```bash
docker build -t node-red-app .
```

Once the image is built, you can run the container with:
```bash
docker run -d -p 1880:1880 --name node-red-app node-red-app
```

## Data Storage

Inside the database folder, you will find the Dockerfile and the SQL script to create the database and the table.

Build the docker image
```bash
docker build -t mssql-database .
```

Once the image is built, you can run the container with:
```bash
docker run -d -p 1433:1433 --name mssql-database mssql-database
```

## AspNetCore App

Inside the app folder, you will find the Dockerfile.

Build the docker image
```bash
docker build -t myaspnetcoreapp .
```

Once the image is built, you can run the container with:
```bash
docker run -d -p 33443:33443 --name myaspnetcoreapp myaspnetcoreapp
```




#!/bin/bash

# Define the required Python libraries
required_libraries=(
    paramiko
    nvdlib
    reportlab
)

# Install required Python libraries using pip with progress bar
echo "Installing required Python libraries..."
pip install --progress-bar=on "${required_libraries[@]}" >/dev/null 2>&1

# Check if installation was successful
if [ $? -eq 0 ]; then
    echo "Python libraries installed successfully."
else
    echo "Error installing Python libraries. Exiting."
    exit 1
fi

# Check if user wants to execute Docker-related commands
if [ "$1" == "--docker" ]; then
    # Start PostgreSQL container
    echo "Starting PostgreSQL container..."
    docker run --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -d postgres:12.7

    # Clone repository
    echo "Cloning repository..."
    git clone https://github.com/vavkamil/dvwp.git
    cd dvwp

    # Start Docker Compose services
    echo "Starting Docker Compose services..."
    docker-compose up -d --build

    # Run wp-cli to install WordPress
    echo "Running wp-cli to install WordPress..."
    docker-compose run --rm wp-cli install-wp

    # Start Docker Compose services again
    echo "Starting Docker Compose services again..."
    docker-compose up -d

    # Script completed successfully
    echo "Setup completed successfully."
    
else
    echo "Skipping Docker-related commands. Setup completed."
fi

exit 0

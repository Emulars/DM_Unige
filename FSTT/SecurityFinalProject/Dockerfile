# Use an official Python runtime as the base image
FROM python:3.9-slim

# Install Vim, SSH, and mutool
RUN apt-get update && apt-get install -y \
    vim \
    openssh-server \
    mupdf-tools

# Set up SSH (optional)
RUN mkdir /var/run/sshd

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
# Copy the bin, configuration, and python directories into the container at /app
COPY bin /app/bin
COPY configuration /app/configuration
COPY python /app/python

# Install required Python libraries
RUN pip install --progress-bar=on \
    paramiko \
    nvdlib \
    reportlab

# Optional: You can set an entrypoint if needed, or leave it to the default
ENTRYPOINT ["/bin/bash"]

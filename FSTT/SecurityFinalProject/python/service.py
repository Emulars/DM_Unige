import logging
from vulnerability import Vulnerability
import nvdlib
import subprocess
import paramiko
import socket

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

class Service:
    def __init__(self, ip, port, service_name, service_location, container_name, user, password, version_command):
        self.ip = ip
        self.port = port
        self.service_name = service_name
        self.version_command = version_command
        self.version = None
        self.vulnerabilities = []

        self.service_location = service_location
        self.container_name = container_name
        self.user = user
        self.password = password

    def get_version(self):
        logging.info(f"Getting version for {self.service_name} at {self.ip}:{self.port}...")

        try:
            # Handle the Local case
            if self.service_location.lower() == "local":
                
                # Handle the case for a Docker container
                if self.container_name:
                    # Create the command to be executed directly onto the docker container
                    cmd = 'sudo docker exec ' + self.container_name + ' ' + self.version_command
                else:
                    cmd = self.version_command

                version_output = subprocess.check_output(cmd, shell=True).decode().strip()


            # Handle the Remote case
            elif self.service_location.lower() == "remote":
                ssh = paramiko.SSHClient()
                ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
                ssh.connect(self.ip, port=self.port, username=self.user, password=self.password, timeout=10)

                # Handle the case for a Docker container
                if self.container_name:
                    # Create the command to be executed directly onto the docker container
                    cmd = 'docker exec ' + self.container_name + ' ' + self.version_command
                else:
                    cmd = self.version_command

                stdin, stdout, stderr = ssh.exec_command(cmd)
                version_output = stdout.read().decode().strip()
                ssh.close()

            # Save the founded version
            self.version = version_output
            logging.info(f"Found version for {self.service_name} => {self.version}")

        except subprocess.CalledProcessError as e:
            logging.error(f"Error: Unable to retrieve version. {e}")
        except paramiko.AuthenticationException as e:
            logging.error(f"Error: SSH authentication failed. {e}")
        except paramiko.SSHException as e:
            logging.error(f"Error: Unable to establish SSH connection. {e}")
        except socket.timeout as e:
            logging.error(f"Error: SSH connection timed out. {e}")

    def clean_description(self, description):
        # Remove extra characters from the description
        cleaned_description = description.strip("('").strip("',)").replace("\\n", "\n")
        # Extract only the value from the description
        value_start_index = cleaned_description.find("'value': '") + len("'value': '")
        value_end_index = cleaned_description.find("'", value_start_index)
        return cleaned_description[value_start_index:value_end_index]

    def check_vulnerabilities(self):
        if not self.version:
            logging.warning(f"Checking vulnerabilities for {self.service_name} is skipped because no version is provided.")
            return  # Skip if no version is provided

        logging.info(f"Checking vulnerabilities for {self.service_name} {self.version}...")

        results = nvdlib.searchCVE(keywordSearch=f'{self.service_name} {self.version}', keywordExactMatch=False)  # True

        for eachCVE in results:
            # Extract and clean the description
            description = self.clean_description(str(eachCVE.descriptions[0]))

            vulnerability = Vulnerability(str(eachCVE.id),
                                        str(eachCVE.vulnStatus),
                                        str(eachCVE.actionDue ) if hasattr(eachCVE, 'actionDue') else '',
                                        str(eachCVE.requiredAction ) if hasattr(eachCVE, 'requiredAction') else '',
                                        str(description),
                                        str(eachCVE.url),
                                        str(eachCVE.score[2]))

            self.vulnerabilities.append(vulnerability)
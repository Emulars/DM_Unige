
    Author: Miggiano Davide - 4840761

# Vulnerability Scanner

This Python project is designed to scan services, identify their versions, and check for vulnerabilities based on their versions. It generates a PDF report listing the vulnerabilities found, including their details such as CVE ID, severity, status, description, URL, and actions required.

## Dependencies
- `reportlab`: for generating PDF reports.
- `nvdlib`: for querying the National Vulnerability Database (NVD) for vulnerabilities.
- `paramiko`: for SSH communication with remote services.
- `json`: for loading configuration data.
- `logging`: for logging messages during the scanning process.

## Pre-requisites (maybe not necessary for custom services)
- Docker is installed
- Docker-compose is installed
- Git is installed

## Usage

### Non-Docker way
1. Clone the repository
2. Navigate inside the root folder of the project
3. Navigate to `bin/` folder and run the script by executing the following: `bash non-docker-setup.sh`
    * if you run the script without any argument, it will only install Python libraries.
    * If you run it with the `--docker` argument, it will execute Docker-related commands to install some test services
4. If needed start the services that need to be scanned
5. Navigate to the directory that contains the configuration file for the services: `configuration/configuration.json`
6. Open the `configuration/configuration.json` file with the preferred text editor   
7. Modify the file with the needed information
8. Navigate to `bin/` folder and run the script by executing the following: `sh VulnerabilitScanner.sh`
9. The result of the scanned services could be found in the `configuration/vulnerabilities.pdf` file

### Docker way
1. Clone the repository
2. Navigate inside the root folder of the project
3. Execute the creation of the docker image: `docker build -t vulnerabilty-scanner .`
4. Start the docker container: `docker run -it -d --name vuln-scanner vulnerabilty-scanner`
5. Access the container: `docker exec -it vuln-scanner /bin/bash`
6. If needed start the services that need to be scanned
7. Navigate to the directory that contains the configuration file for the services: `configuration/configuration.json`
8. Open the `configuration/configuration.json` file with the following command: `vim configuration.json`
    * arrow to move inside the file
    * `Esc` to exit insert mode
    * `:wq` and `Enter` to save the changes
9. Modify the file with the needed information
10. Navigate to `bin/` folder and run the script by executing the following: `sh VulnerabilitScanner.sh`
11. The result of the scanned services could be found in the `configuration/vulnerabilities.pdf` file
12. To open and visualize the pdf on the cli the following command can be used: `mutool draw -F txt vulnerabilities.pdf`

## Functionality
1. **Loading Configuration**: Loads the configuration data from the `configuration/configuration.json` file, which contains details of the services to be scanned.
2. **Scanning Services**: For each service listed in the configuration, it retrieves the version information using either a local command or SSH for remote services.
3. **Checking Vulnerabilities**: Utilizes the NVD database to check for vulnerabilities related to the service's version.
4. **Generating PDF Report**: Generates a PDF report (`configuration/vulnerabilities.pdf`) listing all the vulnerabilities found, including their details.

## Configuration
The `configuration.json` file should contain a list of service objects, each with the following properties:
- `ip`: IP address of the service (or remote server).
- `port`: Port number of the service (or remote server).
- `service_name`: Name of the service.
- `service_location`: Location of the service (either "local" or "remote").
- `container_name`: (Optional) Docker container name if the service is running in a container.
- `user`: Username for SSH authentication (if applicable).
- `password`: Password for SSH authentication (if applicable).
- `version_command`: Command to retrieve the version of the service.

## Logging
The application logs messages of different levels (INFO, ERROR, WARNING) to provide insights into the scanning process. Logs are displayed in the console.

## Notes
- Ensure that the necessary permissions are granted for executing commands and accessing remote services.
- Update the `version_command` property in the configuration file according to the specific command required to retrieve the service version.
- For `Docker over SSH` the given user should be in a Unix group that allows to run the docker command without the superuser command (sudo). The followig command can be used to prepare a suitable environment:
    - `sudo groupadd docker`
    - `sudo gpasswd -a $USER docker`


## Useful links
- [CVE](https://cve.mitre.org/cgi-bin/cvekey.cgi?keyword=Wordpress+5.3)
- [NVD API](https://nvd.nist.gov/general/news/api-20-announcements)
- [NVD Results](https://nvd.nist.gov/vuln/search?results_type=overview&query=wordpress+5.3&search_type=all&form_type=Basic&queryType=phrase&isCpeNameSearch=false)
- [nvdlib 0.7.6](https://pypi.org/project/nvdlib/)
- [NVDLib Doc](https://nvdlib.com/en/latest/v2/CVEv2.html#searching-cves)
- [vulnerslib](#https://pypi.org/project/vulners/)
- [ssh init](https://linuxconfig.org/how-to-install-start-and-connect-to-ssh-server-on-fedora-linux)

## Docker command

### Postgres
    docker run --name postgres-db -e POSTGRES_PASSWORD=mysecretpassword -d postgres:12.7


### Wordpress, MySQL, Apache (phpMyAdmin) 
    git clone https://github.com/vavkamil/dvwp.git
    cd dvwp
    docker-compose up -d --build
    docker-compose run --rm wp-cli install-wp
    docker-compose up -d

### Create docker image
    docker build -t vulnerabilty-scanner .
    docker run -it -d --name vuln-scanner vulnerabilty-scanner
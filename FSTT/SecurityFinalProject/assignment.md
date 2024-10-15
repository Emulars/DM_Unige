# Assignment
For this assignment, you will implement a simple monitoring service for web service environments.

Although basic information related to Python modules are provided, the program can be implemented in any other programming language.

The project should be considered an individual project. Hence, each submission is valid for a single student.

The submitted work will be discussed during the oral part of the exam.

## The need
Let's suppose you work in a small company with a local website. The website is composed by a simple and common environment setup: one Apache web server hosting Wordpress, plus one MySQL database hosting data.

Your aim is to monitor the company's services to assess their potential exposure to new threats.

You'll use public vulnerability database(s) for such purpose.

## Inputs provided
A list of network services (e.g., represented by their IP, port, base URL, etc., plus service type such as Apache, Wordpress, MySQL)

## Output provided
A list of vulnerabilities affecting each service, if any

## Program behavior
The program will scan each service to dynamically 

    1. find the running version of the service software (e.g. Wordpress version 6.4.3), hence 
    2. identify potential vulnerabilities, in function of the service type and the running version found.

In detail, considering point 

    1. a dynamic retrieval of the service software version will be needed; instead, considering point 
    2. by searching on public vulnerabilities database(s), a list of potential vulnerabilities affecting the specific software version will be provided.

## Testing
You can quickly test the program by creating multiple Docker containers of different types (e.g, vulnerable and not vulnerable, custom containers, etc.), hence provide their references as input to the program. To respect legal requirements, it is required to test the system on local services only (you cannot run it against a public server on the Internet).

## Release instructions
The tool source code must be released as a single ZIP file on the AulaWeb page of the course, also including a README.md mark-down text file describing the tool and containing a dedicated section with detailed step-by-step instructions useful to replicate the scenario from scratch, also including information on how to run, test and set up the considered services, used for the oral live demonstration.

## Evaluation
Evaluation of the assignment will consider the following:

1. Sufficient (passed/not passed): the implemented tool is working and responds to the assignment, implementing at least one of all three modules mentioned before (Apache, Wordpress, MySQL).
2. Modules support (2 points max): all of the three modules mentioned (Apache, Wordpress, MySQL) are supported by the software.
3. Input/output (2 points max): the quality of the input/output of the tool will be evaluated, considering input data formats and output representation.
4. Code quality (2 points max): the ability to manage specific conditions (e.g., runtime check of the service type with output provided, offline services, etc.) will be evaluated, along with the designing and programming approaches adopted.
5. Docker support (2 points max): the software is provided as a Dockerized and replicable tool.
6. Additional modules (2 points max): the software embeds at least one additional module for additional specific modules (e.g., a different webservice, a DBMS, a CMS, a FTP server, etc.).
7. Extensibility (3 points max): it will be evaluated the extensibility of the tool (e.g. to dynamically load external modules able to identify additional service types).

Evaluation will also involve an oral discussion of the implemented tool, with live execution of it.
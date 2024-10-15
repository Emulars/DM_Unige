# First FSTT Assignment - Test Case

Author: Davide Miggiano - 4840761

## Description

There are two sub-folders in **src** folder:
- main: contains all the .java files regarding the base class
- test: contains all the test case .java files

To compute the coverage of the created test cases I've followed the guide at this link: https://medium.com/@karlrombauts/setting-up-unit-testing-for-java-in-vs-code-with-maven-3dc75579122f

Command to run the coverage report: mvn jacoco:prepare-agent test install jacoco:report

The result of the coverage can be found in the folder: *target/site/jacoco/index.html* and can be opened with any browser.

Notes: each time the test cases are modified the command to create the coverage file should be runned.

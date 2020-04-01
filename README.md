# Email Checker

This is a Spring Boot web service, given a list of emails, it would specify the total number of unique emails in it.
This is the task given by Fetch Rewards for a job application.

## Technology

 - Java
 - Spring Boot
 - Maven Build
 - Apache Tomcat
 - JDK V6 [required]

## Instructions

To run the service, simply execute the jar given in the project, it contains all the required dependencies and would execute the server
```
java -jar ./emailChecker.jar
```  
  
The service would run on localhost and port would be 8080, so once it is started you can run it in the following manner
```
localhost:8080/testemail@gmail.com, test.email+spam@gmail.com, test.email@gmail.com
```  
Here the list of emails will be passed after the "/" in the URL and the program will automatically display the requested result.

Few examples have been shown in the directory test_results for reference.

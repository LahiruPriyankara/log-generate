This is support for both slf4j and Logger as well.
This will create create error log and non-error logs as separate files(Inside project and out side location as well)
Logger configuration has been done using logback.xml.
Assign values to the variables and access those in logback.xml those two classes have been added(Slf4jMDCFilter and Slf4jMDCFilterConfiguration). 

Read:https://medium.com/@d.lopez.j/spring-boot-setting-a-unique-id-per-request-dd648efef2b


To test non - error logs
http://localhost:1111/app/get/one

To Check error logs
http://localhost:1111/app/get/two

Postman collection have been given with project.

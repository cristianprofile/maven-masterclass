Spring Maven Java 1.8
=======================

Multi-module maven project example using SPRING 4 and java 1.8

- Spring boot module, use Spring without xml and Spring boot actuactor (admin services deployed)
- Simple web app spring mvc using services
- Rest Service implementation example with repository and mail access
- Repository access with spring data jpa
- Unitary and Integration test concept using hsldb and mockito (http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html)

------------------------------------------------------------------------------------------------------

NEW SPRING BOOT MVC APP CREATED, ENJOY IT  

run spring-boot-mvc-web-example module with maven  "mvn spring-boot:run" and access to http://localhost:9090/pizza
and user user "user@ole.com" and password user

- Spring boot mvc with Spring Security access
- i18n
- Responsive bootstrap css witn Tiles 3
- 
------------------------------------------------------------------------------------------------------

To test web mvc app type:  mvn install jetty:run or sort command mvn deploy (jetty:run goal is linked to maven deploy phase)

- http://localhost:8080/SpringMVC/   (spring mvc jsp model)

If you want to access to Rest Service example api then you need to type this url:

- http://localhost:8080/SpringMVC/base (get list of all bases)
- http://localhost:8080/SpringMVC/base/1 (get base info with id=1)
- http://localhost:8080/SpringMVC/base/1 (delete base info with id=1)
- http://localhost:8080/SpringMVC/base (post create new base sending json info. Example "name":"rolling pizza" )
- http://localhost:8080/SpringMVC/base (update update existing base sending json info. Example {"name":"rolling pizza 2","id":1})
------------------------------------------------------------------------------------------------------

If you want to access to Rest Service with Spring boot module "spring-boot-mvc" first run mvn spring-boot:run:

- http://localhost:9090/base (get list of all bases)
- http://localhost:9090/base/1 (get base info with id=1)
- http://localhost:9090/base/1 (delete base info with id=1)
- http://localhost:9090/base (post create new base sending json info. Example "name":"rolling pizza" )
- http://localhost:9090/base (update update existing base sending json info. Example {"name":"rolling pizza 2","id":1})

When you run Spring boot app Spring actuator add features to monitore your services:

- http://localhost:9091/metrics (Spring Boot Actuator includes a metrics service with 
“gauge” and “counter” support. A “gauge” records a single value; and a “counter” records a delta 
(an increment or decrement). Metrics for all HTTP requests are automatically 
recorded, so if you hit the metrics endpoint should see a sensible response.)
- http://localhost:9091/health (you can check if your app is available)
- http://localhost:9091/mappings (list of your app HTTP endpoints)

More info about Spring Actuator at: [Spring Actuator](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-actuator "Spring Actuator")





You can access ppt at:

Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven [Presentation ppt](http://www.slideshare.net/cristianromeromatesanz/maven-31576343 "Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven")

------------------------------------------------------------------------------------------------------
Note 1: If you want to use spring profiles you can use maven enviroment variable like this:

-Dspring.profiles.active="profile1,profile2"


New features coming soon!!!!!Spring boot refactor code without xml config 2015!!!!

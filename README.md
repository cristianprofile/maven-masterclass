maven-masterclass
=======================

Multi-module maven project example using SPRING 3

- Simple web app spring mvc using services
- Rest Service implementation example with repository and mail access
- Repository access with spring data jpa
- Unitary and Integration test concept

To test web app type:  mvn install jetty:run 

http://localhost:8080/SpringMVC/   (spring mvc jsp model)

If you want to access to Rest Service example api then you need to type this url:

http://localhost:8080/SpringMVC/base (get list of all bases)
http://localhost:8080/SpringMVC/base/1 (get base info with id=1)
http://localhost:8080/SpringMVC/base/1 (delete base info with id=1)
http://localhost:8080/SpringMVC/base (post create new base sending json info. Example "name":"rolling pizza" )
http://localhost:8080/SpringMVC/base (update update existing base sending json info. Example {"name":"rolling pizza 2","id":1})


You can access to video course an ppt of presentation at url below:

Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven [Presentation ppt](http://www.slideshare.net/cristianromeromatesanz/maven-31576343 "Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven")

Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven [Video Course](https://www.youtube.com/watch?v=kUxSyVCLcQI "Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven")

Jenkins/cloudbeed IC of my projects [Jenkins](http://cristianprofile.ci.cloudbees.com "Cristian Romero Matesanz WUL4 #Training Thursday3 - Maven")

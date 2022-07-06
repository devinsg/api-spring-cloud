# spring cloud functions
- Coursera: https://www.coursera.org/learn/spring-cloud-overview
- PluralSight: Java Microservices with Spring Cloud: Developing Services

# run command
- ./mvnw spring-boot:run

# Netflix Open Source Software:
- Netflix OSS is a cloud platform used for the majority of the services within Netflix, it is part of the Spring Cloud Project, the platform provides:
- Service Registration
- Service to service communication through Load Balanced Service Discovery
- Service Registration Removal

# Service Registration
- Eureka is a REST based service, it primaly used in AWS Cloud for locating services for the purpose of load balancing
- These services contain a Registry of services that have registered themselves as being available to Eureka instance
- Continue "heart-beat" interactions from registered services inform the Eureka service that a registered service is still active. If the service does not send a "heart-beat" for a configured period time, it is removed from the registry
- The registry has the DNS/IP Address entry for the registed services and retrieved using a service id (name)
- The Eureka Server comes with a Java based client component called the Eureka Client that simplied interactions with the Eureka Server

# Eureka Server Registration
- Eureka Client fetch the registry information from the Eureka Server, and cached it locally with themselves
- It not only send the heart-beat to say "I am still here", it will also pull the master registry from the Eureka Service at a configured frequency to keep a local copy up to date. So as service are removed or added to the registry the client services to get "hear about it"
- In order to make service to service communication, it lookup a service on its local registry via a service id. This gets the DNS entry, IP Address, ports. Then, it can use RestTemplate to make remote call to the service
- If services are scaled, the registry has multiple entries for one service id, it uses a Load Balancer to make requests to the subset of actual Service Instances (DNS entries) retrieved

# Spring Cloud @EnableEurekaServer
- Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot apps through auto configuration for binding to Spring Environment. A Spring Boot application with spring-cloud-started-eureka-server dependency can launch a Eureka Service on the default port of http://localhost:8761/eureka
- setup @EnableEurekaServer from dependency: spring-cloud-starter-netflix-eureka-server

# Eureka Server Configuration
- the Eureka Server port can be changed via an application.yaml file
- furthermore, configuration can instruct that this "service" is not to register with another Eureka Service it self nor fetch an existing registry from any running Eureka Service
- 

# spring cloud functions
- Coursera: https://www.coursera.org/learn/spring-cloud-overview
- PluralSight: Java Microservices with Spring Cloud: Developing Services
- Spring Cloud Netflix OSS: https://spring.io/projects/spring-cloud-netflix
- Service Registration: https://spring.io/guides/gs/service-registration-and-discovery/
- run command: ./mvnw spring-boot:run

# Netflix Open Source Software:
Netflix OSS is a cloud platform used for the majority of the services within Netflix, it is part of the Spring Cloud Project, the platform provides:
- Service Registration
- Service to service communication through Load Balanced Service Discovery
- Service Registration Removal

# Spring Cloud Netflix:
Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot apps through autoconfiguration and binding to the Spring Environment and other Spring programming model idioms. With a few simple annotations, you can quickly enable and configure the common patterns inside your application and build large distributed systems with battle-tested Netflix components. The patterns provided include Service Discovery (Eureka). Spring Cloud Netflix features:
- Service Discovery: Eureka instances can be registered and clients can discover the instances using Spring-managed beans
- Service Discovery: an embedded Eureka server can be created with declarative Java configuration

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

# Eureka Console
- navigating to http://localhost:1111/ we can confirm that our Eureka service is up and running via the Eureka Console. Although it currently has no services in its registry

# Eureka Client
- the next thing to do is to create a Spring Boot Service and register it with the running Eureka Service
- we will create a basic service reporting the population of the capital cities of the world

# Yaml configuration of a service
- we configure a port to run the embedded Tomcat server instance and register it with a running Eureka server (defaultZone) with a unique identifier (instanceId)

# Service Registration
- a service is not available for discovery by clients until the Eureka and Registered Service Registries has the same metadata (this could take 3 heart-beats of 30 seconds each). You can change the period by setting the property eureka.instance.leaseRenewwallIntervallnSeconds
- conversely, the property eureka.instance.leaseExpirationDurationInSeconds expires and removes a service from the Eureka Registry after Eureka Service has not received 3 consecutive missing heart-beats of 30 seconds each. We can change the default with out own value

# @EnableDiscoveryClient
- as Spring Boot/Spring Cloud has opinionated defaults set up for you
- when Spring Cloud Netflix and Eureka Core are on the classpath of your Spring Boot application, just using @EnableDiscoveryClient on the SpringBootApplication class will locate a Eureka Service and register the service



# Service Discovery - Circuit Breakers - Clients
- register a service with Eureka that has a Ribbon Client for load balanced communication with other services
- configure a service for inter service communication using client side load balancing via Ribbon
- understand how Hystrix implements the Circuit Breaker Pattern

# Load Balancing:
- a fundamental part of Microservices architecture is that we want to maximize availability of our services via scaling
- access to the distributed service can be controlled via Load Balancing as a means to optimize the distribution of workloads across multiple services
- client-side load balancing delivers a list of server IP addresses to the client, then, the client randomly selects the IP from the list and makes the call to that address

# Ribbon
- in Netflix OSS, Ribbon provides client side load balancers
- with Ribbon attached to your service, the service will select from the local registry of services, any entry for the desired service and place them in a subset
- then, it will use a round robin algorithm to direct the current and any subsequent requests to each service in the extracted list of services

# Eureka with Ribbon
- Eureka provides the service registry for all Netflix services, while Ribbon clients are typically created and configured for each of the registered services.
- When Eureka is used in conjunction with Ribbon(both are on the classpath), the subset or list of potential services from the local registry is called the RibbonServerList, and is an extenssion of DiscoveryEnabledNIWSServerList
- Ribbon uses the local Eureka Server Service registry to identify server/service instances to be leveraged in a load balanced manner by service id
- it then uses an instance of com.netflix.loadbalancer.DynamicServerListLoadBalancer to delegate to the selected service instance

# Client Side Load Balancing
- each service instance is identified by its service id and any associated server instances in the RibbonServerList
- ribbon then delegates requests in a round robin fashion to each service in the RibbonServerList as the requests are received by the Eureka Client of the service
- if we start two instances of the capitol-service, both will be registered with a running instance of the Eureka Service

# Prepare our Client Service for Ribbon
- annotate a Spring Boot App with @RibbonClient with the name of a service that we wish to call. This is in fact nothing more than a label to an entry in the yaml configuration file

# Configuration
- next we match that service name we used to the Actual service id in the cached local registry of the service via the services yaml configuration to identify the RibbonServerList
- ribbon now has the RibbonServerList and use the round robin algorithm to delegate to each instance. This is Service Discovery as you do not know the physical IP address, or host name of the service. As new instance are added to the registry, the RibbonServerList gets bigger, if an instance goes out of service, it gets slower

# Ribbon
- using Netflix Ribbon to execute Client Side Load Balancing in Spring Cloud projects
- Client Side Load Balancing: https://howtodoinjava.com/spring-cloud/spring-boot-ribbon-eureka/
- Simple Static List of Servers: https://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon
- Hystrix and Circuit Breaker: https://howtodoinjava.com/spring-cloud/spring-hystrix-circuit-breaker-tutorial/

# Circuit Breakers:
- it isolates the points of access between the services, stops cascading failures across them and provides fallback options
- once spring-cloud-starter-hystrix is added to your classpath, you utilize two key annotations for Spring Cloud to incorporate a Circuit Breaker Pattern using Hystrix
- the @EnableCircuitBreaker annotation is used to scan for any circuit breaker implementations on the classpath, like Hystrix
- the @HystrixCommand(fallbackMethod = "methodName") over the method that might fail, calling another service, database down...; it identifies a default fallback method to execute in the case of a failure. It actually wraps the class in a proxy that is connected to the Hystrix Circuit Breaker and delegates to the identified fallbackMethod in the event failure.
- if an exception is thrown, like connectivity or timeout, the fallback method is invoked and will continue to be called on subsequent requests. A check is done to see if the "real method can be executed periodically"; if it can the read method will be called from that point onwards
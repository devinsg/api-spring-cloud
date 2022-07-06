# Pluralsight & Coursera: api-spring-cloud
- api spring cloud functions
- Java Microservices with Spring Cloud: Developing Services
- https://www.coursera.org/learn/spring-cloud-overview
- using Spring Cloud with Netflix OSS specifically projects: Eureka, Ribbon, Hystrix, Feign, Zuul
- run command: ./mvnw spring-boot:run

# Spring Cloud Overview
- Micro Service: https://microservices.io/
- Service Registry: https://microservices.io/patterns/service-registry.html
- Service Discovery: https://microservices.io/patterns/client-side-discovery.html
- Load Balancing: https://www.citrix.com/solutions/application-delivery-controller/load-balancing/what-is-load-balancing.html#:~:text=Load%20balancing%20is%20defined%20as,server%20capable%20of%20fulfilling%20them.
- Circuit Breakers: https://techblog.constantcontact.com/software-development/circuit-breakers-and-microservices/

# What are Microservices?
- Microservices (microservice architecture) is an architectural style that structures an application as a collection of services, they are:
- Highly maintainable and testable
- Loosely coupled
- Independently deployable
- Organized around business capabilities
- Owned by a small team

# Microservice Architecture
- Microservice Architecture style is an alternative where applications are built via a suite of services responsible for specific functionalities. The aim: individual software components become independently, replaceable, upgradeable, scalable.
- Microservice Architecture puts each element of functionality into a separate service
- Spring Cloud provides tools for developers to quickly build some of the common patterns in Microservice architecture: Load Balanced Service Discovery, Service Scaling, Service Registration, Service Deployment. Many features are included in SpringBoot which extends Spring Cloud
- Service Discovery in Microservice: this becomes problematic as service instances are dynamically assigned network locations upon registration and upon auto-scaling (copying) as client traffic rises

# Client Discovery
- the client is responsible for determining the network locations of available service instances
- the client queries a service registry, which is a database of available service instances, the registry has the DNS/IP address entry specifics
- the client use load-balancing algorithm to select one of the available service instances

# Circuit Breakers
- in distributed environment: calls to remote resources and services can fail due to slow network connections, timeouts, or resources being unavailable. In such situations it might be pointless for an application to continously retry an operation that is unlikely to success, but instead accept the operation has failed.
- the Circuit Breaker pattern was introduced to prevent an application from repeatedly trying to execute an operation that likely to fail. Instead, it allows the application to continue without waiting for the fault to be fixed by calling a fallback operation.
- the Circuit Breaker pattern also enables an application to detect whether the fault has been resolved. If the problem appears to have been fixed, the application can try to invoke the original operation again.

# Q1: Which one of these statements refers to a Microservice architecture?
Individual software components are independently deployable, replaceable, upgradeable, and scalable.

# Q2: If each service in a Microservice architecture is responsible for a subset of the overall functionality, what do we need to tie the workflow together?
Orchestrator - Correct, that’s exactly what we want, something to control the request as it delegates through a series of services to provide the goal of the overall request.

# Q3: What does a load balancer do? 
A load balancer will direct requests in a pre-determined frequency from one “clone” to the next. 
Replication can continue with multiple copies of the same war, on the same server (different ports), or across different servers.

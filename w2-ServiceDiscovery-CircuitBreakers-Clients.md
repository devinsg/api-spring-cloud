# Service Discovery - Circuit Breakers - Clients

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

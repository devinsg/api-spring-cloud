# Zuul and Feign
- Zuul Routing using Routes Endpoint: https://www.baeldung.com/zuul-load-balancing
- Zuul Filters: https://spring.io/guides/gs/routing-and-filtering/
- Feign Clients: https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html
- Feign Example: https://www.baeldung.com/intro-to-feign

# Client Service
- create a Feign Client Service to access a desired service as an alternative to RestTemplate
- create an Edge or Gateway Service using Zuul to map incoming request to services

# Feign clients
- Feign will aid you in creating REST clients through an alternative to RestTemplate to lookup your services
- It requires minimal configuration and code
- With Feign added on the classpath, we must add the @EnableFeignCLients annotation to our Application Class which will provide default configurations for the resolution of REST services Feign implementations
- REST client: create an interface and add the @FeignClient, our environment will create a proxy implementation of the interface at runtime and look for the endpoint from our Eureka registry. Then, the proxy will delegate to the real service instances through a ribbon load balancer
- the name attribute identifies the service that we want to discover
- the @GetMapping identify the endpoint we desire from the identified service that we want to delegate to
@FeignClient(name = "capitolServer")
interface CityClient {
    @GetMapping(value = "/capitol/{code}")
    public String get(@PathVariable("id") String id) throws JSONException;
}

# Zuul
- zuul is used as the front door for all requests from various devices and websites to the backend of a Netflix streaming application
- at the center of Zuul is a series of Filters that are capable of performing a range of actions during the routing of HTTP requests and responses to desired services

# Zuul as a gateway or edge service:
- map all requests (wildcard urls) to services
- all requests come through zuul and may be filtered inbound/outbound
- use ribbon client side load balancing to access service instances

# Zuul filters
- PRE filters execute before routing to the origin
- ROUTING filters handle routing the request to a destination. This is where an HTTP request is built and sent using Apache HTTP Client or Netflix Ribbon
- POST filters execute after the request has been routed to the service on the return route so to speak
- ERROR filters execute when an error occurs during one of the other phases

# create an Edge service
- Spring Cloud Netflix includes an embedded Zuul proxy which we can enable with the @EnableZuulProxy annotation. This will turn our application into a proxy that forwards relevant calls to other services such as our capitol-service
- It will use a set of routes defined in yaml to match incoming requests to a destination service. This is all encapsulated in the proxy that uses a load balanced RestTemplate to make the HTTP Request to the desired service


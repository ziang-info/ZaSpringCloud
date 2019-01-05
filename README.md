# za-spring-cloud
Example of using spring cloud: eureka feign

Assumes Project (from [ZaSpringCloud](https://github.com/ziang-info/ZaSpringCloud)) is running on http://localhost:8761

## building

`mvn package`

## za-eureka-server

run `java -jar ZaEurekaServer/target/za-eureka-server-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:8761](http://localhost:8761)

You should see `Spring Eureka Console`

## za-eureka-client (service-hi)

run `java -jar za-eureka-client/target/za-eureka-client-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:8763/hi?name=latti](http://localhost:8763/hi?name=latti)

You should see `hi hello,i am from port:8763 and 29`

## za-feign-consumer 

Verify it is functioning at [http://localhost:8765/hi?name=latti](http://localhost:8765/hi?name=latti)

You should see `hi latti,i am from port:8763 and 36`

### Wait a while when service works.
You may see an error while the eureka/ribbon caches warm up similar to the following:

    Whitelabel Error Page

    This application has no explicit mapping for /error, so you are seeing this as a fallback.

    Wed Jan 07 13:13:39 MST 2015
    There was an unexpected error (type=Internal Server Error, status=500).
    com.netflix.client.ClientException: Load balancer does not have available server for client: HelloServer

It should go away shortly.


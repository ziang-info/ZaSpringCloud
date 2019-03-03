# za-spring-cloud
Example of using spring cloud: eureka feign

Assumes Project (from [ZaSpringCloud](https://github.com/ziang-info/ZaSpringCloud)) is 
running on [http://localhost:8761](http://localhost:8761)

## building

`mvn package`

## za-eureka-server (Register Center) 8761

run `java -jar ZaEurekaServer/target/za-eureka-server-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:8761](http://localhost:8761)

You should see `Spring Eureka Console`

## za-eureka-client (Service Provoder: service-hi) 8762

run `java -jar za-eureka-client/target/za-eureka-client-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:8763/hi?name=latti](http://localhost:8763/hi?name=latti)

You should see `hi hello,i am from port:8763 and 29`

If you want to run multiple service provider just like following:

    java -jar provider-0.0.1-SNAPSHOT.jar --server.port=8762  
    java -jar provider-0.0.1-SNAPSHOT.jar --server.port=8763


## za-feign-consumer (Service Consumer)  8765

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

## za-ribbon-consumer (Service Consumer) 8771

Verify it is functioning at [http://localhost:8771/ribbon-consumer](http://localhost:8771/ribbon-consumer)

You should see like:
    `hi ribbon,i am from port:8762 and 7`
    or
    `hi ribbon,i am from port:8763 and 35`

[http://localhost:8771/sayHi](http://localhost:8771/sayHi)
[http://localhost:8771/sayHi2](http://localhost:8771/sayHi2)
[http://localhost:8771/sayHi3](http://localhost:8771/sayHi3)
[http://localhost:8771/book1](http://localhost:8771/book1)


## za-zuul-service (Router & Filter) 8781

打开浏览器访问：http://localhost:8781/api-a/hi?name=latti ;

浏览器显示：

    hi latti,i am from port:8762 and 164(Ribbon+RestTemplate)

打开浏览器访问：http://localhost:8781/api-b/hi?name=latti ;

浏览器显示：

    hi latti,i am from port:8762 and 162 (FEIGN)

Add Filer then visit: http://localhost:8781/api-b/hi?name=lattimore
    `token is empty`


## za-config-server 8888

http://localhost:8888/foo/dev
```
{"name":"foo","profiles":["dev"],"label":null,"version":"00d32612a38898781bce791a4a845e60a7fbdb4e","state":null,"propertySources":[]}
```

## za-config-client 8881

http://localhost:8881/hi

```
foo version 2
```

## za-spring-mvc (1&2) 主要用来演示SpringMVC 来注册微服务 Eureka

Refer to:
    https://github.com/devbhuwan/eureka-client-with-springmvc
    https://stackoverflow.com/questions/35409492/eureka-service-discovery-without-spring-boot

http://localhost:8881/hello

## za-sidecar 8070
    Refer to README.md under project folder.

# Reference

   [Spring RestTemplate](https://blog.csdn.net/u012702547/article/details/77917939/)



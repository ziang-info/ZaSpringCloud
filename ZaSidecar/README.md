
Spring Cloud - Sidecard
    通过Sidecar集成non-spring-boot应用服务到spring-cloud


ZaEurekaServer (Registration Server)
    http://localhost:8761/

ZaSpringMvc (Service Provider or 3rd part App)
    http://localhost:8080/mvc/
    
        ---/health  健康接口
        
        ---/genHiStr 提供的服务接口（测试用）  参数name（String）
        
        ---/hi  通过Sidecar调用了SpringCloud中service-hi中的getbook1接口
        
ZaSidecar (Sidecar)
    http://localhost:8070/
    
    http://localhost:8070/hosts/za-sidecar 
        
ZaFeignConsumer （测试接口服务）
    http://localhost:8765/hi2?name=nice%20day%E4%B8%AD%E5%9B%BD
    http://localhost:8765/hi3
    
    
ZaZuul （测试接口服务）
    http://localhost:8781/api-sc/mvc/genHiStr?name=3
  
  
第三方应用调用SpringCloud服务也是通过Sidecar
        http://localhost:8070/<service-id>/<method-name>
        如： http://localhost:8070/service-hi/getbook1
        
        
        
注意：
    1. Sidecar服务注册成功后，到服务正常工作需要"些许"时间，需要耐性等待。
    2. 坑，因为mvc服务路径有一个前缀mvc，所以绑定服务不要漏掉了。
    3. 接口中的中文乱码问题
        
        

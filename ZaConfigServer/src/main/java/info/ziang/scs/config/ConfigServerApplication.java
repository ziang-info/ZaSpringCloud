package info.ziang.scs.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
Refer to:
    https://www.fangzhipeng.com/springcloud/2018/08/30/sc-f6-config/
 */

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

    /*
    启动程序：访问http://localhost:8888/foo/dev

    {"name":"foo","profiles":["dev"],"label":"master",
    "version":"792ffc77c03f4b138d28e89b576900ac5e01a44b","state":null,"propertySources":[]}


    证明配置服务中心可以从远程程序获取配置信息。

    http请求地址和资源文件映射如下:
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties

     */
}

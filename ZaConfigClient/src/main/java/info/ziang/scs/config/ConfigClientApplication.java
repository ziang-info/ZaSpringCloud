package info.ziang.scs.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
/*
Refer to:
    https://www.fangzhipeng.com/springcloud/2018/08/30/sc-f6-config/

    Config Repo :
        https://github.com/forezp/SpringcloudConfig/blob/master/respo/config-client-dev.properties

    Notice:
        application.properties
        spring.application.name=config-client
 */

@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}

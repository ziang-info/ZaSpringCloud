package info.ziang.scs.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

@SpringBootApplication
@EnableSidecar // 这是一个组合注解，它整合了三个注解，分别是@EnableCircuiBreaker，@EnableDiscoveryClient和@EnableZuulProxy
public class SidecarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }
}

package info.ziang.scs.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	private int a = 0;

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {

		System.out.println("#####provider#######");

		String str = "hi "+name+",i am from port:" +port + " and " + a++;

		System.out.println("######provider######");

		return str;
	}

	@RequestMapping("/info")
	public String info() {
		return "I am from port:" + port;
	}

}

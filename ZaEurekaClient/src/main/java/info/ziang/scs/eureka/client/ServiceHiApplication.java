package info.ziang.scs.eureka.client;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	private static Logger log = LogManager.getLogger(ServiceHiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	//@Autowired
	//private DiscoveryClient client;

	/**
	 * Use to count.
	 */
	private int a = 0;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {

		log.info("#####provider#######");

		String str = "hi "+name+",i am from port:" +port + " and " + a++;

		log.info("######provider###### {}", str);

		/*
		List<InstanceInfo> instances = client.getInstancesById("service-hi");
		for (int i = 0; i < instances.size(); i++) {
			log.info("/hello,host:" + instances.get(i).getIPAddr() + ",service_id:" + instances.get(i).getInstanceId());
		}
		*/

		return str;
	}

	@RequestMapping("/info")
	public String info() {
		return "I am from port:" + port;
	}

}

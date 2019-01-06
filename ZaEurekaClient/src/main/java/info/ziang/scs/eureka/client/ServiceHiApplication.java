package info.ziang.scs.eureka.client;


import info.ziang.scs.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;


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

	@RequestMapping(value = "/getbook1", method = RequestMethod.GET)
	public Book book1() {
		return new Book("三国演义", 90, "罗贯中", "花城出版社");
	}

	@RequestMapping(value = "/getbook2", method = RequestMethod.POST)
	public Book book2(@RequestBody Book book) {
		System.out.println("getbook2: " + book.getName());
		book.setPrice(33);
		book.setAuthor("曹雪芹");
		book.setPublisher("人民文学出版社");
		return book;
	}

	@RequestMapping(value = "/getbook3", method = RequestMethod.PUT)
	public Book book3(@RequestBody Book book) {
		System.out.println("getbook3: " + book.getName());
		book.setPrice(33);
		return book;
	}

	@RequestMapping(value = "/getbook4", method = RequestMethod.DELETE)
	public Book book4(@RequestBody Book book) {
		System.out.println("getbook4: " + book.getName());
		book.setPrice(33);
		return book;
	}


}

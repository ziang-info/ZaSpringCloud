package info.ziang.scs.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import info.ziang.scs.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL_PREFIX_HI = "http://SERVICE-HI/hi?name=";
    private static final String URL_PREFIX_BOOK = "http://SERVICE-HI/getbook";

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloController() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://SERVICE-HI/hi?name=ribbon", String.class);

        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();

        StringBuffer result = new StringBuffer();
        result.append("responseEntity.getBody()：<em>").append(body).append("</em><hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");

        return result.toString();

    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping("/sayHi")
    public String sayHello() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX_HI + "{1}", String.class, "张三");
        return responseEntity.getBody();
    }

    @RequestMapping("/sayHi2")
    public String sayHello2() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "李四");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(URL_PREFIX_HI + "{name}", String.class, map);
        return responseEntity.getBody();
    }

    @RequestMapping("/sayHi3")
    public String sayHello3() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL_PREFIX_HI + "{name}").build().expand("王五").encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/book1")
    public Book book1() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity(URL_PREFIX_BOOK + "1", Book.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/book2")
    public Book book2() {
        Book book = restTemplate.getForObject(URL_PREFIX_BOOK + "1", Book.class);
        return book;
    }

    // NOT VERIFIED YET
    @RequestMapping("/book3")
    public Book book3() {
        Book book = new Book();
        book.setName("红楼梦");
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity(URL_PREFIX_BOOK + "2", book, Book.class);
        return responseEntity.getBody();
    }

    /*
     postForObject
     postForLocation
    */

    // NOT VERIFIED YET
    @RequestMapping("/putbook")
    public void put() {
        Book book = new Book();
        book.setName("红楼梦");
        restTemplate.put(URL_PREFIX_BOOK + "3/{1}", book, 99);
    }

    // NOT VERIFIED YET
    @RequestMapping("/deletebook")
    public void delete() {
        restTemplate.delete(URL_PREFIX_BOOK + "4/{1}", 100);
    }


}

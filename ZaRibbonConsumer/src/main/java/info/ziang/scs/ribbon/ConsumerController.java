package info.ziang.scs.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloController() {
        return restTemplate.getForEntity("http://SERVICE-HI/hi?name=ribbon", String.class).getBody();
    }
}

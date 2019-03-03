package info.ziang.ssc.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    SidecarService sidecarService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        String rFromServiceHi = schedualServiceHi.sayHiFromClientOne(name);

        rFromServiceHi += " (FEIGN)";

        return rFromServiceHi;
    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String sayHiFromSidecar(@RequestParam String name) {
        String rFromServiceHi = sidecarService.sayHiFromSideCar(name);

        rFromServiceHi += " (FEIGN from sidecar)";

        return rFromServiceHi;
    }


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi3")
    public String hi3() {
        return restTemplate.getForEntity("http://za-sidecar/mvc/genHiStr?name={1}", String.class, ":)").getBody();
    }

}


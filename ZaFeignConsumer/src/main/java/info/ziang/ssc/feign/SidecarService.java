package info.ziang.ssc.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "za-sidecar", name = "za-sidecar", fallback = SidecarServiceFallback.class)
public interface SidecarService {
    @RequestMapping(value = "/mvc/genHiStr", method = RequestMethod.GET)
    String sayHiFromSideCar(@RequestParam(value = "name") String name);
}
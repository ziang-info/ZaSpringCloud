package info.ziang.ssc.feign;

import org.springframework.stereotype.Component;

@Component
public class SidecarServiceFallback implements SidecarService {

    public String sayHiFromSideCar(String name) {
        return "Fallback: hi, " + name + ", ERROR!!!";
    }
}

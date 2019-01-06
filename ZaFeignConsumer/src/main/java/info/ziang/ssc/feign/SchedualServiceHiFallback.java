package info.ziang.ssc.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiFallback implements SchedualServiceHi{

    public String sayHiFromClientOne(String name) {
        return "Fallback: hi, " + name + ", ERROR!!!";
    }
}

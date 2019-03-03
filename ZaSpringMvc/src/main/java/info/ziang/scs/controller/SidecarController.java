package info.ziang.scs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SidecarController {

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to Sidecar Example.";
    }

    /**
     * 3rd part app health api (MUST)
     *
     * @return
     */
    @RequestMapping(value = "/health", produces = "application/json")
    public Health health() {

        Health h = new Health();
        return h;
    }

    class Health {
        String status = "UP";

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    /**
     * 3rd part app service provided.
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/genHiStr", method = RequestMethod.GET)
    public String genHiStr(String name) {
        return "Hi, " + name + " (from Sidecar)";
    }
}

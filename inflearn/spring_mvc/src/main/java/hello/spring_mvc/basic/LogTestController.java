package hello.spring_mvc.basic;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {
    // private final Logger log = LoggerFactory.getLogger(getClass()); 

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        log.trace("trace Log = {}", name);
        log.debug("debug Log = {}", name);
        log.warn("warn Log = {}", name);
        log.error("error Log = {}", name);
        log.info("info Log = {}",name);
        return "ok";
    }
}

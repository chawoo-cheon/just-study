package hello.spring_mvc.basic.requestmapping;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {
    
    @RequestMapping(value = "/hello-basic")
    public String helloBasic(){
        log.info("hello basic log = {}");
        return "ok";
    }

    @RequestMapping(value = "/hello-basic-v1", method = RequestMethod.GET)
    public String helloBasic_v1(){
        log.info("hello basic log = {}");
        return "ok";
    }

    @GetMapping("/hello-basic-v2")
    public String helloBasic_v2(){
        log.info("hello basic log = {}");
        return "ok";
    }

    /**
     * Path Variable 사용
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping Path userId = {}",data);
        return "";
    }

    /**
     * Path Variable 다중 사용
     */
    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPathV2(@PathVariable String userId, @PathVariable String orderId){
        log.info("mapping Path userId = {}",userId);
        log.info("mapping Path orderId = {}",orderId);
        return "";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}

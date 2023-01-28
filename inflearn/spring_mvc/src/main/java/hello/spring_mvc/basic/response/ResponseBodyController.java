package hello.spring_mvc.basic.response;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import hello.spring_mvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@ResponseBody //class level 에 붙여도 가능, 전부 
//@RestController = @Controller + @ResponseBody
public class ResponseBodyController {
    
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletRequest req , HttpServletResponse res ) throws IOException{
        res.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2(){
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3(){
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> reponseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("dd");
        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v1")
    public HelloData reponseBodyJsonV2(){        
        HelloData helloData = new HelloData();
        helloData.setUsername("dd");
        log.info("helloData = {}",helloData);
        return helloData;
    }



}

package hello.spring_mvc.basic.request;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequestParamsController {
    
    @RequestMapping("request-param-v1")
    public void requestParamV1(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {} , age = {}", username, age);
        
        response.getWriter().write("ok");
    }
    
    @RequestMapping("request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
        @RequestParam("age") int memberAge){
        
        log.info("username = {} , age = {}", memberName, memberAge);
        return "ok";
    }
    
    @RequestMapping("request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age){
        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-required")
    public String requestParamRequired(
        @RequestParam(required = true) String username, 
        @RequestParam(required = false) Integer age){
            //int a = null -> int 자료형에는 null이 들어 갈수 없다. 
            //Integer a = null -> o
        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-default")
    public String requestParamDefault(
        @RequestParam(required = true, defaultValue = "guest") String username, 
        @RequestParam(required = false, defaultValue = "-1") Integer age){
            //int a = null -> int 자료형에는 null이 들어 갈수 없다. 
            //Integer a = null -> o
        log.info("username = {} , age = {}", username, age);
        return "ok";
    }

    @RequestMapping("request-param-map")
    public String requestParamMap(
        @RequestParam Map<String,Object> paramMap){
            //int a = null -> int 자료형에는 null이 들어 갈수 없다. 
            //Integer a = null -> o
        log.info("username = {} , age = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}

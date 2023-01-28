package hello.spring_mvc.basic.request;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.spring_mvc.basic.HelloData;
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

    @ResponseBody
    @RequestMapping("model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        //ModelAttribute는 객체를 생성하고, 요청 파라미터의 값도 모두 들어가 있다. 
        //HelloData객체를 생성하고 프로퍼티를 찾는다. 그리고 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 바인딩 한다.
        log.info("username = {} , age = {}", helloData.getUsername(), helloData.getAge());
        log.info("hello Data = {}", helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        //ModelAttribute를 생략할 수 있다. 
        //String , int, Integer 같은 단순 타입은 @RequestParam 을 사용
        //나머지는 @ModelAttribute 단, argument resolver 지정은 예외 ( HttpServlet ... )
        log.info("username = {} , age = {}", helloData.getUsername(), helloData.getAge());
        log.info("hello Data = {}", helloData);
        return "ok";
    }
} 

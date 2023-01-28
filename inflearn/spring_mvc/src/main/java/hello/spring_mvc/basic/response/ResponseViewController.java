package hello.spring_mvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("hello").addObject("data","Hello!!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","Hello Cheon");
        return "hello";
    }

    @RequestMapping("/hello")
    public void responseViewV3(Model model){
        //권장하지 않음
        model.addAttribute("data","Hello Cheon");
    }
}
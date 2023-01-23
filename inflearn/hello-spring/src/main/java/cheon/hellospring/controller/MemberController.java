package cheon.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cheon.hellospring.service.MemberService;

@Controller
public class MemberController {

    MemberService memberService;
    
    @Autowired 
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

}

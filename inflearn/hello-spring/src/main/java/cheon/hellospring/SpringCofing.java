package cheon.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cheon.hellospring.repository.MemberRepository;
import cheon.hellospring.repository.MemoryMemberRepository;
import cheon.hellospring.service.MemberService;

@Configuration 
public class SpringCofing {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    
}

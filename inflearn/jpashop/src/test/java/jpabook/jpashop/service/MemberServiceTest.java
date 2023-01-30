package jpabook.jpashop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;


//@RunWit(SpringRunner.class) -> @ExtendWith로 변경됨
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
//기본적으로 rollback 이 되어버린다.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;
    
    @Test
    public void join() throws Exception{
        //given
        Member member = new Member();
        member.setName("cheon");
        
        //when
        Long saveId = memberService.join(member);

        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));
    }

    // @Test(expected = IllegalStateException.class) //junit4
    @Test
    public void duplicateMemberException() throws Exception{
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("cheon");
        member2.setName("cheon");

        //when
        memberService.join(member1);
        try{
            memberService.join(member2); //예외가 발생해야함.
        }catch(IllegalStateException e){
            return;
        }
       
        //then
        fail("예외발생!");
    }
}

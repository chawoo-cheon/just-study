package cheon.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cheon.hellospring.domain.Member;
import cheon.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    /**
     * 테스트는 정상 flow 도 중요하지만 exception flow (예외 플로우)가 훨씬 중요하다. 
     */

    MemoryMemberRepository memoryMemberRepository;
    MemberService memberService; 
    
    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore(); 
    }

    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("cheon");
         
        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
         assertThat(member.getName()).isEqualTo(findMember.getName()); 
    }

    @Test
    public void exceptDuplicateMember(){
         //given
         Member member1 = new Member();
         member1.setName("Spring");

         Member member2 = new Member();
         member2.setName("Spring");
         
         //when
         memberService.join(member1);
         
         IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
         assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); 

         /* try{
            memberService.join(member2);
            fail("");
         }catch(IllegalStateException exception){
            assertThat(exception.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
         } */

         //then 
    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }
}

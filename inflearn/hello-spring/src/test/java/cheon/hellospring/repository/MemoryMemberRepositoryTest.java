package cheon.hellospring.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import cheon.hellospring.domain.Member;
import net.bytebuddy.build.Plugin;

class MemoryMemberRepositoryTest {
    
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore(); 
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Cheon");
        repository.save(member);
        
        Member result =  repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
}
package cheon.hellospring.service;

import java.util.List;
import java.util.Optional;
import cheon.hellospring.domain.Member;
import cheon.hellospring.repository.MemberRepository;

/**
 * 서비스 설계의 경우 비즈니스에 의존적으로 설계하는 것이 좋음
 */
 
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입 
     */
    public Long join(Member member){ 
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId(); 
    }

    private void validateDuplicateMember(Member member){
        // Optional<Member> result =  memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재하는 회원입니다.") ;
        // });
        memberRepository.findByName(member.getName()) 
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.") ;
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll(); 
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
package org.zerock.p01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.p01.Entity.Member;
import org.zerock.p01.dto.MemberDTO;
import org.zerock.p01.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional

public class MemberServiceImpl implements MemberService {
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Override
    public String memberRegister(MemberDTO memberDTO){
        Member member = modelMapper.map(memberDTO, Member.class);
        String memberId = memberRepository.save(member).getMemberId();
        return memberId;
    }

    @Override
    public boolean login(String memberId, String memberPw){
        Optional<Member> result = memberRepository.findById(memberId);
        if(result.isPresent()){
            Member member = result.get();
            if(member.getMemberPw().equals(memberPw)){
                return true;
            }
        }
        return false;
    }

//    @Override
//    public MemberDTO logout(String memberId, String memberPw){
//
//    }

    @Override
    public void memberDelete(String memberId){
        Optional<Member> result = memberRepository.findById(memberId);
        Member member = result.orElseThrow();
        if(result.isPresent()){
            memberRepository.deleteById(memberId);
        }
    }
}

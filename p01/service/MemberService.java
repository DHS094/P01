package org.zerock.p01.service;

import org.zerock.p01.Entity.Member;
import org.zerock.p01.dto.MemberDTO;

public interface MemberService {
    // memberRegister
//    void memberRegister(MemberDTO memberDTO);
    String memberRegister(MemberDTO memberDTO);
    // login
    boolean login(String memberId, String memberPw);
    // logout
//    MemberDTO logout(String memberId, String memberPw);
    // memberDelete
    void memberDelete(String memberId);
}

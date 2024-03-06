package com.test.service;

import com.test.auth.SnsAuth;
import com.test.dto.MemberDTO;


public class MemberService {

    private SnsAuth snsAuth;

    public MemberService(SnsAuth snsAuth){
        this.snsAuth = snsAuth;
    }

    public boolean findMember(MemberDTO memberDTO){
        boolean result = snsAuth.login(memberDTO);

        return result;
    }
}

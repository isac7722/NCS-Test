package com.test.auth.impl;

import com.test.auth.SnsAuth;
import com.test.dto.MemberDTO;


public class NaverAuth implements SnsAuth {

    @Override
    public boolean login(MemberDTO memberDTO) {
        MemberDTO naverMember = new MemberDTO("naver", "pwd");

        if(!naverMember.getId().equals(memberDTO.getId())){
            System.out.println(" 네이버 회원의 아이디가 같지 않습니다.");
            return false;
        }else{
            if(!naverMember.getPwd().equals(memberDTO.getPwd())){
                System.out.println("네이버 회원의 비밀번호가 같지 않습니다.");
                return false;
            }
        }

        return true;
    }
}

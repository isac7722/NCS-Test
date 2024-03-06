package com.test.auth.impl;

import com.test.auth.SnsAuth;
import com.test.dto.MemberDTO;


public class KakaoAuth implements SnsAuth {
    @Override
    public boolean login(MemberDTO memberDTO) {
        MemberDTO kakaoMember = new MemberDTO("kakao", "pwd");

        if(!kakaoMember.getId().equals(memberDTO.getId())){
            System.out.println(" 카카오 회원의 아이디가 같지 않습니다.");
            return false;
        }else{
            if(!kakaoMember.getPwd().equals(memberDTO.getPwd())){
                System.out.println("카카오 회원의 비밀번호가 같지 않습니다.");
                return false;
            }
        }

        return true;
    }
}

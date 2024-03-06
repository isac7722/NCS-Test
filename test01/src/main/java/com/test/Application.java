package com.test;



import com.test.auth.impl.GoogleAuth;
import com.test.auth.impl.KakaoAuth;
import com.test.auth.impl.NaverAuth;
import com.test.dto.MemberDTO;
import com.test.service.MemberService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        MemberService memberService; // 초기화할 필요 없음


        while(true) {
            MemberDTO memberDTO = new MemberDTO();
            System.out.println("사용자 인증 프로그램입니다.");
            System.out.println("1. 구글 로그인");
            System.out.println("2. 네이버 로그인");
            System.out.println("3. 카카오 로그인");
            System.out.println("9. 프로그램 종료");
            System.out.print("로그인 한 인증 수단을 선택해주세요");
            Scanner scr = new Scanner(System.in);
            int choice = scr.nextInt();
            scr.nextLine();


            System.out.println("아이디를 입력 해주세요");
            memberDTO.setId(scr.nextLine());
            System.out.println("비밀번호를 입력 해주세요");
            memberDTO.setPwd(scr.nextLine());

            boolean result;
            String type;
            switch (choice){
                case 1 : memberService = new MemberService(new GoogleAuth());
                         result = memberService.findMember(memberDTO);
                         if(result){
                             System.out.println("구글 로그인에 성공하였습니다." + memberDTO.getId());
                         }
                
                             break;
                    
                
                case 2 : memberService = new MemberService(new NaverAuth());
                    result = memberService.findMember(memberDTO);
                    if(result){
                        System.out.println("네이버 로그인에 성공하였습니다." + memberDTO.getId());
                    }

                    break;
                
                

                case 3 : memberService = new MemberService(new KakaoAuth());
                    result = memberService.findMember(memberDTO);
                    if(result){
                        System.out.println("카카오 로그인에 성공하였습니다." + memberDTO.getId());
                    }

                    break;

                case 9 :
                    System.out.println("로그인을 종료합니다."); return;


            }
            
            


        }


    }
}

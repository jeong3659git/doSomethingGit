package hello.core;


import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

/**
 * 회원 도메인과 실행 테스트
 * */
public class MemberApp {
    public static void main(String[] args){
        // 1. 회원서비스
            //MemberService memberService = new MemberServiceImpl();
            AppConfig appConfig = new AppConfig();                      // 3) c
            MemberService memberService = appConfig.memberService();


        // 2. 회원 생성
        Member member = new Member(1l, "memberA" , Grade.VIP);
        memberService.join(member);

        // 3. 회원 조회 (회원Id로 조회)
        Member finMember = memberService.findMember(1l);
        System.out.println("new member = " + member.getName());     // 생성한 회원 이름
        System.out.println("find Member = " + finMember.getName()); // 조회하는 회원 이름
    }
}

// 3) AppConfig 이후 수정
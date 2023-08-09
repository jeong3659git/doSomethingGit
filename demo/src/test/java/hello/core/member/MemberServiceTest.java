package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * 회원 도메인 - 회원 가입 테스트 ( jUnit )
 * */
class MemberServiceTest {
    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService;   // 3) c

    @BeforeEach
    public void beforeEach(){       // 3) c
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        // given
        Member memberTest = new Member(1l, "memberB", Grade.VIP);   // 회원 생성

        // when
        memberService.join(memberTest); // 회원 저장
        Member findMemberTest = memberService.findMember(1l); // 회원 조회

        // then
        Assertions.assertThat(memberTest).isEqualTo(findMemberTest); // 저장된 회원과 조회한 회원 값이 동일한지 확인

        // 해당 검증이 참일 경우( 두값이 동일할 경우 ) 아무일도 없고,
        // 두 값이 다르면 해당 테스트는 실패로 끝난다.
    }

}


/*
*   필기 -
*   의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있음.
*
*   3) AppConfig 이후 수정
* 
* */

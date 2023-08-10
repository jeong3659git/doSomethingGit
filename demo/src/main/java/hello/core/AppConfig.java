package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(
                memberRepository()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(), discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();   // -- 할인정책 변경시 구성요소에서 해당부분만 바꿔주면 사용영역에서 변경할 필요가 없다.
    }


    /*
   // 리팩토링 적용 후
   public MemberService memberService(){
        return new MemberServiceImpl(
                memberRepository()
        );
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
            memberRepository(), discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
       return new RateDiscountPolicy();   // -- 할인정책 변경시 구성요소에서 해당부분만 바꿔주면 사용영역에서 변경할 필요가 없다.
    }
*/
/*
    // 리팩토링 전
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
            new MemoryMemberRepository(),
            new FixDiscountPolicy()
        );
    } 
 */

}
// new MemoryMemberRepository() 이 부분이 중복 제거
// MemoryMemberRepository 를 다른 구현체로 변경할 때 한 부분만 변경


// @ ---> Spring 으로 전환 ( 지금까지는 JAVA 형태로 진행 )
package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

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
        return new FixDiscountPolicy();
    }
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
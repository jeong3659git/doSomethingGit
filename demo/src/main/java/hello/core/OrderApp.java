package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 주문과 할인 정책 실행
 * */
public class OrderApp {
    public static void main(String[]args){
        MemberService memberService = new MemberServiceImpl();  // 회원 서비스
        OrderService orderService = new OrderServiceImpl();     // 주문 서비스

        long memberId = 1l;
        Member member1 = new Member(1l, "member2a" , Grade.VIP);
        //Member member2 = new Member(1l, "member2b" , Grade.BASIC);

        memberService.join(member1);

        Order order = orderService.createOrder(memberId, "itemA", 100000);

        System.out.println("order =  "+ order);
    }
}

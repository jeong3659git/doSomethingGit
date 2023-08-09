package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.Grade;

/**
 * 주문 할인 정책 구현체
 * */
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount; // 회원등급이 VIP일 경우 1000을 반환
        }else{
            return 0;
        }
    }
}

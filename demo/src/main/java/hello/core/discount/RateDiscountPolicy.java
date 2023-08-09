package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 할인 정책 변경으로 인한 할인 서비스(비율) 구현체 추가
 * */
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;   // 10% 할인

    @Override
    public int discount(Member member, int price) {

        if( member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }

    }
}

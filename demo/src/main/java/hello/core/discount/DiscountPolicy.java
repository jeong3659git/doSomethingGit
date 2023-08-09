package hello.core.discount;

/**
 * 주문과 할인 도메인 개발
 * */
import hello.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 금액 대상
     * */
    int discount(Member member, int price);
}

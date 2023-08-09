package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * 주문 서비스 구현체
 * */
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * 주문생성
     * */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { 
        Member member = memberRepository.findById(memberId);    //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 회원등급에 따른 할인 금액

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문 객체 생성 후 반환
    }
}

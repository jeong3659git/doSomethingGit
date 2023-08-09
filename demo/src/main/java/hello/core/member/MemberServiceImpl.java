package hello.core.member;

/**
 * 회원서비스 구현체
 * */
public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository();  //  1) D
    private final MemberRepository memberRepository;    // 1) C
    public MemberServiceImpl(MemberRepository memberRepository){ // 1) C
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

// 1) AppConfig 이후 변경
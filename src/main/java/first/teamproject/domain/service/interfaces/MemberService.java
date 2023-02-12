package first.teamproject.domain.service.interfaces;

import first.teamproject.domain.member.Member;

public interface MemberService {
    void join(Member member);
    void update(Long memberNo,Member member);
    void withdrawal(Member member);//탈퇴
    Member findByMemberNo(Long memberNo);
}

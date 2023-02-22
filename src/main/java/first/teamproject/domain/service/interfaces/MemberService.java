package first.teamproject.domain.service.interfaces;

import first.teamproject.domain.member.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);
    void update(Long memberNo,Member member);
    void withdrawal(Member member);//탈퇴
    Member findByNo(Long memberNo);

    List<Member> findAll();
}

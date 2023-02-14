package first.teamproject.domain.repository.interfaces;

import first.teamproject.domain.member.Member;

import java.util.List;

public interface MemberRepository {
    void memberSave(Member member);
    void memberUpdate(Long memberId, Member updateMember);
    void memberDelete(Member member);
    Member memberFindByNo(Long memberNo);
    List<Member> memberFindAll();
    void memberClearAll();

}

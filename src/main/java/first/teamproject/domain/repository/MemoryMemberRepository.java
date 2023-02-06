package first.teamproject.domain.repository;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.interfaces.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store=new HashMap<>();
    private static long sequence=0L;
    @Override
    public void memberSave(Member member) {
        member.setMemberNo(sequence++);
        store.put(member.getMemberNo(),member);
    }

    @Override
    public void memberUpdate(Long memberId, Member updateMember) {
        Member findMember = memberFindByNo(memberId);
        findMember.setMemberGrade(updateMember.getMemberGrade());
        findMember.setMemberId(updateMember.getMemberId());
        findMember.setMemberPassword(updateMember.getMemberPassword());
        findMember.setMemberName(updateMember.getMemberName());
        findMember.setMemberAddress(updateMember.getMemberAddress());
        findMember.setMemberEmail(updateMember.getMemberEmail());
        findMember.setMemberPhone(updateMember.getMemberPhone());

    }

    @Override
    public void memberDelete(Member member) {
        store.remove(member.getMemberNo());
    }

    @Override
    public Member memberFindByNo(Long memberNo) {
        return store.get(memberNo);
    }



    @Override
    public List<Member> memberFindAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void memberClearAll() {
        store.clear();
    }
}

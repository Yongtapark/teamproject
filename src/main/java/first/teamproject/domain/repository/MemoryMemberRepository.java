package first.teamproject.domain.repository;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Repository
public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store=new HashMap<>();
    private static long sequence=0L;
    @Override
    public String memberSave(Member member) {
        member.setMEMBER_NO(sequence++);
        store.put(member.getMEMBER_NO(),member);
        return null;
    }

    @Override
    public void memberUpdate(Long memberId, Member updateMember) {
        Member findMember = memberFindByNo(memberId);
        findMember.setMEMBER_GRADE(updateMember.getMEMBER_GRADE());
        findMember.setMEMBER_ID(updateMember.getMEMBER_ID());
        findMember.setMEMBER_PWD(updateMember.getMEMBER_PWD());
        findMember.setMEMBER_NAME(updateMember.getMEMBER_NAME());
        findMember.setMEMBER_ADDRESS(updateMember.getMEMBER_ADDRESS());
        findMember.setMEMBER_EMAIL(updateMember.getMEMBER_EMAIL());
        findMember.setMEMBER_PHONE(updateMember.getMEMBER_PHONE());

    }

    @Override
    public void memberDelete(Member member) {
        store.remove(member.getMEMBER_NO());
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

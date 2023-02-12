package first.teamproject.domain.service;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import first.teamproject.domain.repository.MemoryMemberRepository;
import first.teamproject.domain.service.interfaces.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.memberSave(member);
        log.info("joinedMember={}",member.toString());
    }

    @Override
    public void update(Long memberNo, Member member) {
        memberRepository.memberUpdate(memberNo,member);
        log.info("updatedMember={}->{}", findByMemberNo(memberNo).toString(),member.toString());
    }

    @Override
    public void withdrawal(Member member) {
        memberRepository.memberDelete(member);
    }

    @Override
    public Member findByMemberNo(Long memberNo) {
        return memberRepository.memberFindByNo(memberNo);
    }

}

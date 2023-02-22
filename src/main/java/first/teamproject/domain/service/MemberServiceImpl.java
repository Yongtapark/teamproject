package first.teamproject.domain.service;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.OracleMemberRepository;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import first.teamproject.domain.service.interfaces.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(Member member) {
        String memberNo = memberRepository.memberSave(member);
        log.info("joinedMember={}",member.toString());
        return Long.valueOf(memberNo);
    }

    @Override
    public void update(Long memberNo, Member member) {
        memberRepository.memberUpdate(memberNo,member);
        log.info("updatedMember={}->{}", findByNo(memberNo).toString(),member.toString());
    }

    @Override
    public void withdrawal(Member member) {
        memberRepository.memberDelete(member);
    }

    @Override
    public Member findByNo(Long memberNo) {
        return memberRepository.memberFindByNo(memberNo);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.memberFindAll();
    }

}

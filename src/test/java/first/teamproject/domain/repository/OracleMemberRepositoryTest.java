package first.teamproject.domain.repository;

import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class OracleMemberRepositoryTest {
    @Autowired
    OracleMemberRepository memberRepository;

    @Test
    void memberSave() {
        Member member =new Member("memberId","asdasd","맴버이름","주소입니다.","이메일입니다.","010123456");
        memberRepository.memberSave(member);
    }

    @Test
    void memberUpdate() {
        Long memberNo = memberRepository.memberFindByNo(1L).getMEMBER_NO();
        Member updatedMember =new Member("123","변경주소입니다.","이메변깅일입니다.","변경010123456");
        memberRepository.memberUpdate(memberNo,updatedMember);

    }

    @Test
    void memberDelete() {
        Member member = memberRepository.memberFindByNo(2L);
        memberRepository.memberDelete(member);
    }

    @Test
    void memberFindByNo() {
        Member acualMember = memberRepository.memberFindByNo(15L);
        assertThat(acualMember).isNotNull();
        assertThat(acualMember.getMEMBER_ID()).isEqualTo("member01");
    }

    @Test
    void memberFindAll() {
        List<Member> members = memberRepository.memberFindAll();
        log.info("members={}",members);
        //log.info("member_no={}", members.stream().map(Member::getMEMBER_NO).collect(Collectors.toList()));



    }


}
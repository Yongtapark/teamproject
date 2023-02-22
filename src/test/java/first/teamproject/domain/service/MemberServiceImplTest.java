package first.teamproject.domain.service;


import first.teamproject.domain.member.Member;

import first.teamproject.domain.repository.OracleMemberRepository;

import first.teamproject.domain.service.interfaces.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@Slf4j
class MemberServiceImplTest {
    @Autowired
    private OracleMemberRepository OracleMemberRepository;
    @Autowired
    MemberService memberService;




    @Test
    void join(){
        Member member=new Member(
                "memberId",
                "memberPassword",
                "memberName",
                "asdasdasdasdas",
                "email",
                "101-2131-5135"
        );
        memberService.join(member);

    }
    @Test
    void delete(){

        //when
        Member byNo = memberService.findByNo(9L);
        memberService.withdrawal(byNo);

        //then
        assertThat(memberService.findByNo(9L)).isNull();
    }

    @Test
    void update(){

        Member updateMember=new Member(

                "updatedPassword",
                "asdasdasdasdas",
                "updatedEmail",
                "updated 101-2131-5135");
        memberService.update(32L,updateMember);

        //then
       // assertThat(member.getMEMBER_ID()).isEqualTo("updatedId");
        assertThat(memberService.findByNo(32L).getMEMBER_PWD()).isEqualTo("updatedPassword");
        //assertThat(member.getMEMBER_NAME()).isEqualTo("updatedName");
        assertThat(memberService.findByNo(32L).getMEMBER_ADDRESS()).isEqualTo("asdasdasdasdas");
        assertThat(memberService.findByNo(32L).getMEMBER_EMAIL()).isEqualTo("updatedEmail");
        assertThat(memberService.findByNo(32L).getMEMBER_PHONE()).isEqualTo("updated 101-2131-5135");
    }
    @Test
    void findAll(){

        List<Member> finMemberList = memberService.findAll();
        log.info("members={}",finMemberList);


    }
    @Test
    void findByNo(){
        Member byNo = memberService.findByNo(32L);
        log.info("byNo={}",byNo);
    }

}

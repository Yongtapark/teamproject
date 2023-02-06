package first.teamproject.domain.service;

import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import first.teamproject.domain.order.Address;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import first.teamproject.domain.repository.MemoryMemberRepository;
import first.teamproject.domain.service.interfaces.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
class MemberServiceImplTest {
        MemberService memberService = new MemberServiceImpl();
        MemberRepository repository=new MemoryMemberRepository();
        @AfterEach
        void afterEach(){
            repository.memberClearAll();
        }



    @Test
    void join(){
        Member member=new Member(
                Grade.ADMIN,
                "memberId",
                "memberPassword",
                "memberName",
                new Address("city","street","zipcode"),
                "email",
                "101-2131-5135"
        );
        memberService.join(member);
        Member findMember = memberService.findByMemberNo(member.getMemberNo());
        assertThat(member).isEqualTo(findMember);
    }
    @Test
    void delete(){
        //given
        Member member=new Member(
                Grade.ADMIN,
                "memberId",
                "memberPassword",
                "memberName",
                new Address("city","street","zipcode"),
                "email",
                "101-2131-5135"
        );
        memberService.join(member);

        //when
        memberService.withdrawal(member);

        //then
        assertThat(memberService.findByMemberNo(member.getMemberNo())).isNull();
    }

    @Test
    void update(){
        //given
        Member member=new Member(
                Grade.ADMIN,
                "memberId",
                "memberPassword",
                "memberName",
                new Address("city","street","zipcode"),
                "email",
                "101-2131-5135"
        );
        memberService.join(member);

        //when
        Member updateMember=new Member(
                Grade.ADMIN,
                "updatedId",
                "updatedPassword",
                "updatedName",
                new Address("city2","street2","zipcode2"),
                "updatedEmail",
                "updated 101-2131-5135");
        memberService.update(member.getMemberNo(),updateMember);

        //then
        assertThat(member.getMemberId()).isEqualTo("updatedId");
        assertThat(member.getMemberPassword()).isEqualTo("updatedPassword");
        assertThat(member.getMemberName()).isEqualTo("updatedName");
        assertThat(member.getMemberAddress().getCity()).isEqualTo(new Address("city2","street2","zipcode2").getCity());
        assertThat(member.getMemberEmail()).isEqualTo("updatedEmail");
        assertThat(member.getMemberPhone()).isEqualTo("updated 101-2131-5135");
    }
    @Test
    void findAll(){

            //given
        Member member1=new Member(
                Grade.ADMIN,
                "memberId",
                "memberPassword",
                "memberName",
                new Address("city","street","zipcode"),
                "email",
                "101-2131-5135"
        );

        Member member2=new Member(
                Grade.ADMIN,
                "updatedId",
                "updatedPassword",
                "updatedName",
                new Address("city","street","zipcode"),
                "updatedEmail",
                "updated 101-2131-5135");

        memberService.join(member1);
        memberService.join(member2);


        //when
        List<Member> finMemberList = repository.memberFindAll();

        //then
        assertThat(finMemberList.size()).isEqualTo(2);
        assertThat(finMemberList).contains(member1,member2);


    }

}
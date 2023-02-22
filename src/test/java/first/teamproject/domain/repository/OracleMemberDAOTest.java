/*
package first.teamproject.domain.repository;

import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class OracleMemberDAOTest {
    @Autowired
    OracleMemberDAO oracleMemberDAO;
    @Test
    void insertTest(){
        Member member =new Member("memberId","asdasd","맴버이름","주소입니다.","이메일입니다.","010123456");
        oracleMemberDAO.insertMember(member);
    }

    @Test
    void updateTest(){
        oracleMemberDAO.updateMember(new Member("123","변경주소입니다.","이메변깅일입니다.","변경010123456"));
    }

    @Test
    void deleteTest(){
        oracleMemberDAO.deleteMember(41L);

    }

    @Test
    void listMember(){
        List<Member> members = oracleMemberDAO.memberList();
        log.info("members.size={},members={}",members.size(), members.iterator().next().getMEMBER_ID());
        assertThat(members).isNotNull();
    }

      @Test
    void findByNo(){
          Member acualMember = oracleMemberDAO.selectMember(1L);
          assertThat(acualMember).isNotNull();
          //assertThat(actualMember).isEqualTo(expectedMember);
      }



}*/

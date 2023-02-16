package first.teamproject.domain.repository;

import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class OracleMemberDAOTest {
    @Autowired
    OracleMemberDAO oracleMemberDAO;
    @Test
    void insertTest(){
        Member member =new Member(Grade.ADMIN,"memberId","asdasd","맴버이름","주소입니다.","이메일입니다.","010123456");
        oracleMemberDAO.insertMember(member);
    }

    @Test
    void updateTest(){
        oracleMemberDAO.updateMember(new Member("memberId","123","변경주소입니다.","이메변깅일입니다.","변경010123456"));
    }

    @Test
    void deleteTest(){
        oracleMemberDAO.deleteMember(13L);
    }

      @Test
    void selectTest(){
          Member expectedMember =new Member(Grade.ADMIN,"memberId","asdasd","맴버이름","주소입니다.","이메일입니다.","010123456");
          String memberNo = oracleMemberDAO.insertMember(expectedMember);
          long memberNoL = Long.parseLong(memberNo);
          log.info("OracleMemberDAOTest.memberNoL={}",memberNoL);
          Member actualMember = oracleMemberDAO.selectMember(memberNoL);
          log.info("OracleMemberDAOTest.actualMember={}",actualMember);
          assertThat(actualMember).isNotNull();
          assertThat(actualMember).isEqualTo(expectedMember);
      }



}
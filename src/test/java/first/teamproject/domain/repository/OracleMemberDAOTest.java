package first.teamproject.domain.repository;

import first.teamproject.domain.member.Grade;
import first.teamproject.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OracleMemberDAOTest {
    @Autowired
    OracleMemberDAO oracleMemberDAO;
    @Test
    void test(){
        oracleMemberDAO.insertMember(new Member(Grade.ADMIN,"memberId","asdasd","맴버이름","주소입니다.","이메일입니다.","010123456"));
    }

}
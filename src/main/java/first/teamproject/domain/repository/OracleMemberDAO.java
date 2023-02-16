package first.teamproject.domain.repository;

import first.teamproject.domain.member.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class OracleMemberDAO {

    @Autowired
    SqlSessionTemplate sqlSession;
    Long sequence= 0L;

    // CRUD 기능의 메소드 구현
    // 회원가입

    public String insertMember(Member member){
        member.setMemberNo(sequence++);
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",member.getMemberNo());
        param.put("member_grade",member.getMemberGrade());
        param.put("member_id",member.getMemberId());
        param.put("member_pwd",member.getMemberPassword());
        param.put("member_address",member.getMemberAddress());
        param.put("member_email",member.getMemberEmail());
        param.put("member_phone",member.getMemberPhone());
        param.put("member_name",member.getMemberName());
        sqlSession.insert("member.insertMember",param);
        return param.get("member_no").toString();

    }



}

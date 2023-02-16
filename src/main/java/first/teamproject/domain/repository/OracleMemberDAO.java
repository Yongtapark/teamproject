package first.teamproject.domain.repository;

import first.teamproject.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.StringTypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.apache.ibatis.type.JdbcType;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@Repository
public class OracleMemberDAO {

    @Autowired
    SqlSessionTemplate sqlSession;
    // CRUD 기능의 메소드 구현
    // 회원가입



    public String insertMember(Member member){
        Map<String,Object> param = new HashMap<>();
        param.put("member_grade",member.getMemberGrade());
        param.put("member_id",member.getMemberId());
        param.put("member_pwd",member.getMemberPassword());
        param.put("member_address",member.getMemberAddress());
        param.put("member_email",member.getMemberEmail());
        param.put("member_phone",member.getMemberPhone());
        param.put("member_name",member.getMemberName());
        sqlSession.insert("member.insertMember",param);
        return param.get("MEMBER_NO").toString();
    }

    public void updateMember(Member member){
        Map<String,Object> param = new HashMap<>();
        param.put("member_id",member.getMemberId());
        param.put("member_pwd",member.getMemberPassword());
        param.put("member_address",member.getMemberAddress());
        param.put("member_email",member.getMemberEmail());
        param.put("member_phone",member.getMemberPhone());
        sqlSession.update("member.updateMember",param);
    }

    public void deleteMember(Long memberNo){
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",memberNo);
        sqlSession.delete("member.deleteMember",param);
    }

    public Member selectMember(Long memberNo){
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",memberNo);
        log.info("OracleMemberDAO.memberNo={}",memberNo);

        Member member = sqlSession.selectOne("member.selectMember", param);
        log.info("OracleMemberDAO.member={}",member);
        return member;

    }


}

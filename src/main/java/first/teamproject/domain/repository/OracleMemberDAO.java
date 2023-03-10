package first.teamproject.domain.repository;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.interfaces.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
//@Repository
public class OracleMemberDAO implements MemberRepository {

    @Autowired
    SqlSessionTemplate sqlSession;
    // CRUD 기능의 메소드 구현
    // 회원가입



    public String insertMember(Member member){
        Map<String,Object> param = new HashMap<>();
        param.put("member_grade",member.getMEMBER_GRADE());
        param.put("member_id",member.getMEMBER_ID());
        param.put("member_pwd",member.getMEMBER_PWD());
        param.put("member_address",member.getMEMBER_ADDRESS());
        param.put("member_email",member.getMEMBER_EMAIL());
        param.put("member_phone",member.getMEMBER_PHONE());
        param.put("member_name",member.getMEMBER_NAME());
        sqlSession.insert("member.insertMember",param);
        return param.get("MEMBER_NO").toString();
    }

    public void updateMember(Member member){
        Map<String,Object> param = new HashMap<>();
        param.put("member_id",member.getMEMBER_ID());
        param.put("member_pwd",member.getMEMBER_PWD());
        param.put("member_address",member.getMEMBER_ADDRESS());
        param.put("member_email",member.getMEMBER_EMAIL());
        param.put("member_phone",member.getMEMBER_PHONE());
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

        Member member = (Member) sqlSession.selectOne("member.selectMember", param);
        log.info("OracleMemberDAO.member={}",member);
        return member;
    }

    public List<Member>memberList(){
        return sqlSession.selectList("member.list");
    }


    @Override
    public String memberSave(Member member) {
        Map<String,Object> param = new HashMap<>();
        param.put("member_grade",member.getMEMBER_GRADE());
        param.put("member_id",member.getMEMBER_ID());
        param.put("member_pwd",member.getMEMBER_PWD());
        param.put("member_address",member.getMEMBER_ADDRESS());
        param.put("member_email",member.getMEMBER_EMAIL());
        param.put("member_phone",member.getMEMBER_PHONE());
        param.put("member_name",member.getMEMBER_NAME());
        sqlSession.insert("member.insertMember",param);
        return param.get("MEMBER_NO").toString();
    }

    @Override
    public void memberUpdate(Long memberId, Member updateMember) {

    }

    @Override
    public void memberDelete(Member member) {

    }

    @Override
    public Member memberFindByNo(Long memberNo) {
        return null;
    }

    @Override
    public List<Member> memberFindAll() {
        return null;
    }

    @Override
    public void memberClearAll() {

    }
}

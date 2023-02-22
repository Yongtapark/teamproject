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
import java.util.Optional;

@Slf4j
@Repository
public class OracleMemberRepository implements MemberRepository {
    SqlSessionTemplate sqlSession;

    public OracleMemberRepository(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    // CRUD 기능의 메소드 구현
    // 회원가입


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
        log.info("member={}",member);
        sqlSession.insert("member.insertMember",param);
        return param.get("MEMBER_NO").toString();
    }

    @Override
    public void memberUpdate(Long memberNo, Member updateMember) {
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",memberNo);
        param.put("member_pwd",updateMember.getMEMBER_PWD());
        param.put("member_address",updateMember.getMEMBER_ADDRESS());
        param.put("member_email",updateMember.getMEMBER_EMAIL());
        param.put("member_phone",updateMember.getMEMBER_PHONE());
        sqlSession.update("member.updateMember",param);
    }

    @Override
    public void memberDelete(Member member) {
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",member.getMEMBER_NO());
        sqlSession.delete("member.deleteMember",param);
    }

    @Override
    public Member memberFindByNo(Long memberNo) {
        Map<String,Object> param = new HashMap<>();
        param.put("member_no",memberNo);
        log.info("OracleMemberDAO.memberNo={}",memberNo);

        Member member = (Member) sqlSession.selectOne("member.selectMember", param);
        log.info("OracleMemberDAO.member={}",member);
        return member;
    }

    @Override
    public List<Member> memberFindAll() {
        return sqlSession.selectList("member.list");
    }

    public Optional<Member> findByMemberId(String memberId){
        /*List<Member> all = memberFindAll();
        for (Member member : all) {

            if(member.getMEMBER_ID().equals(memberId)){
                return Optional.of(member);
            }
        }

        return Optional.empty();*/

        return memberFindAll().stream()
                .filter(member -> member.getMEMBER_ID().equals(memberId)).findAny();
    }
    @Override
    public void memberClearAll() {


    }

}

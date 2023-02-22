package first.teamproject.domain.login;

import first.teamproject.domain.member.Member;
import first.teamproject.domain.repository.OracleMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private  final OracleMemberRepository memberRepository;

    /**
     *  return null 이면 실패
     */

    public Member login(String loginId, String loginPwd){
       /* Optional<Member> byMemberId = memberRepository.findByMemberId(loginId);
        Member member = byMemberId.get();
        if (member.getMEMBER_PWD().equals(loginPwd)){
            return member;
        }else{
            return null;
        }*/

       return memberRepository.findByMemberId(loginId)
               .filter(m->m.getMEMBER_PWD().equals(loginPwd)).orElse(null);
    }



}

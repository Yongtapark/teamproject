package first.teamproject.domain.member;
import lombok.Data;

@Data
public class Member {
    private Long memberNo;
    private Grade memberGrade;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberAddress;
    private String memberEmail;
    private String memberPhone;

    public Member() {
    }

    public Member(Grade memberGrade, String memberId, String memberPassword, String memberName, String memberAddress, String memberEmail, String memberPhone) {
        this.memberGrade = memberGrade;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
    }

    public Member(String memberId,String memberPassword, String memberAddress, String memberEmail, String memberPhone) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
    }
}

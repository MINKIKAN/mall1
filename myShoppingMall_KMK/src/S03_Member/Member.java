package S03_Member;

public class Member {
 private int memberNumber;
 private String memberId;
 private String memberPw;
 private String memberName;
 
 public Member() {}
 @Override
public String toString() {
	return "[회원 번호 " + memberNumber + "]  [회원 아이디 " + memberId + "]  [회원 비밀번호 " + memberPw
			+ "]  [회원 이름 " + memberName + "]";
}


public Member(int memberNumber, String memberId, String memberPw, String memberName) {
	super();
	this.memberNumber = memberNumber;
	this.memberId = memberId;
	this.memberPw = memberPw;
	this.memberName = memberName;
}

public int getMemberNumber() {
	return memberNumber;
}

public void setMemberNumber(int memberNumber) {
	this.memberNumber = memberNumber;
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public String getMemberPw() {
	return memberPw;
}

public void setMemberPw(String memberPw) {
	this.memberPw = memberPw;
}

public String getMemberName() {
	return memberName;
}

public void setMemberName(String memberName) {
	this.memberName = memberName;
}
 
 
}

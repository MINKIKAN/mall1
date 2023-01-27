package S03_Member;

import java.util.ArrayList;

public class MemberDAO {

	private ArrayList<Member> memberlist;
	private int memberNumber;

	public MemberDAO() {
		memberNumber = 1000;
		memberlist = new ArrayList<>();
		setSampleData();

	}

	public void addMember(Member member) {
		memberlist.add(member);
	}

	public int getNextNumber() {
		memberNumber += 1;
		return memberNumber;
	}

	boolean checkMember(String id) {
		for (int i = 0; i < memberlist.size(); i++) {
			if (id.equals(memberlist.get(i).getMemberId())) {
				return true;
			}
		}
		return false;
	}

	boolean checkMemberLogin(String id, String pw) {
		for (int i = 0; i < memberlist.size(); i++) {
			if (id.equals(memberlist.get(i).getMemberId()) && pw.equals(memberlist.get(i).getMemberPw())) {
				return true;
			}
		}
		return false;
	}

	public void setSampleData() {
		Member member = new Member(getNextNumber(), "a", "a", "강민기");
		addMember(member);
		member = new Member(getNextNumber(), "b", "b", "박병준");
		addMember(member);
	}
	
public void printMemberList() {
		for(int i=0; i<memberlist.size(); i++) {
			System.out.println(memberlist.get(i).toString());
		}
	}
}

package S03_Member;

import java.util.Scanner;

import S01_MyUtil.Util;
import S04_ltem.ItemController;
import S06_Cart.CartController;
import S07_Board.BoardController;

public class MemberController {
     private MemberController() {}
     static private MemberController instance = new MemberController();
     static public MemberController getInstance() {
    	 return instance;
     }
     
     private MemberDAO memberDAO;
     private ItemController itemController;
     private CartController cartController;
     private BoardController boardController;
     private Scanner sc;
     
     public void init(MemberDAO memberDAO) {
    	 this.memberDAO = memberDAO;
    	 itemController = ItemController.getInstance();
    	 cartController = CartController.getInstance();
    	 boardController = BoardController.getInstance();
      sc=Util.sc;
      managerSetting();
     }
    public void managerSetting() {
    	if (memberDAO.checkMember("adimin")==false) {
			Member member=new Member(1,"admin","admin","관리자");
			memberDAO.addMember(member);
		}
    }
    public String memberLogin() {
    	System.out.println("===[로그인]===");
    	System.out.println(" [로그인] 아이디 입력 : ");
    	String id=sc.next();
    	System.out.println(" [로그인] 비밀번호 입력 : ");
    	String pw=sc.next();
    	boolean check =memberDAO.checkMemberLogin(id, pw);
    	if (check ==true) {
			System.out.println("["+id+"] 로그인 ");
			return id;
		}
    	return null;
    }
    public void memberJoin() {
    	System.out.println("===[회원가입]===");
    	System.out.println(" [회원가입] 아이디 입력 : ");
    	String id=sc.next();
    	boolean check =memberDAO.checkMember(id);
    	if (check==true) {
			System.out.println(" [중복된 아이디 입니다.] ");
		}else {
			System.out.println(" [회원가입] 비밀번호 입력 : ");
			String pw=sc.next();
    	System.out.println(" [회원가입] 이름 입력 : ");
    	String name=sc.next();
    	int memberNumber= memberDAO.getNextNumber();
    	Member member =new Member(memberNumber, id, pw, name);
    	memberDAO.addMember(member);
    	System.out.println(" [ 회원이 되신걸 축하합니다. ]");
		}
    }
    
    public String menuMember () {
    	while (true) {
			System.out.println(" [1. 쇼핑 ] [2. 장바구니 ] [3. 게시판 ] [0. 뒤로가기 ]");
			int sel =sc.nextInt();
			if (sel==0) {
				return null;
			}else if(sel==1) {
				itemController.menuShop();
			}else if(sel==2) {
			    cartController.menuCart();	
			}else if(sel==3) {
				boardController.boardmenu();
			}
			
		}
    }
public void adminPrintMemberList() {
		memberDAO.printMemberList();
	}
    
    
    
}

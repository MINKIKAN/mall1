package S02_Mall;

import java.util.Scanner;

import S01_MyUtil.Util;
import S03_Member.MemberController;
import S05_Admin.AdminController;

public class MallController {
	private MallController() {
	}

	static private MallController instance = new MallController();

	static public MallController getInstance() {
		return instance;
	}

	private MemberController memberController;
	private AdminController adminController;
	private Scanner sc;
	private String memberLoginId;

	public void init() {
		sc = Util.sc;
		memberController = MemberController.getInstance();
		adminController = AdminController.getInstance();
		memberLoginId = null;
	}

	public String getMemberLoginId() {
		return memberLoginId;
	}

	public void menumall() {
		while (true) {
			System.out.println("=== 쇼핑몰 ===");
			System.out.println("[1] 로그인 [2] 회원가입 [0] 종료 ");
			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
			if (sel == 1) {
				memberLoginId = memberController.memberLogin();
				if (memberLoginId == null) {
					System.err.println(" [로그인 실패]");
				} else if (memberLoginId.equals("admin")) {
					memberLoginId = adminController.menuAdmin();
				} else {
					memberLoginId = memberController.menuMember();
				}
			} else if (sel == 2) {
				memberController.memberJoin();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}
		}
	}
}

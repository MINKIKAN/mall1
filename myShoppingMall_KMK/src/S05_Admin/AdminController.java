package S05_Admin;

import java.util.Scanner;

import S01_MyUtil.Util;
import S03_Member.MemberController;
import S03_Member.MemberDAO;
import S04_ltem.ItemController;
import S06_Cart.CartController;
import S07_Board.Board;
import S07_Board.BoardController;
import S07_Board.BoardDAO;

public class AdminController {
	private AdminController() {
	}

	static private AdminController instance = new AdminController();

	static public AdminController getInstance() {
		return instance;
	}

	private Scanner sc;
	private MemberController memberController;
	private ItemController itemController;
	private CartController cartController;
	private BoardController boardController;

	public void init() {
		sc = Util.sc;
		itemController = ItemController.getInstance();
		cartController = CartController.getInstance();
		memberController = MemberController.getInstance();
		boardController = BoardController.getInstance();
	}

	public String menuAdmin() {
		while (true) {
			System.out.println("[1.회원관리] [2.상품관리] [3.장바구니관리] [4.게시판관리] [0.뒤로가기]");
			int sel = sc.nextInt();
			if (sel == 0) {
				return null;
			} else if (sel == 1) {
				menuMemberAdmin();
			} else if (sel == 2) {
				menuItemAdim();
			} else if (sel == 3) {
				menuCartAdmin();
			} else if (sel == 4) {
				boardAdminmenu();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}

		}
	}

	public void boardAdminmenu() {
		while (true) {
			System.out.println("=== 게시판 관리 ===");
			boardController.adminPrintBoadList();
			System.out.println(" [1. 공지 쓰기 ] [ 2. 글 삭제 ] [3. 글 수정 ] [ 0. 뒤로가기 ]");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				boardController.adminAddContent();
			} else if (sel == 2) {
				boardController.deliteAdminContents();
			} else if (sel == 3) {
				boardController.adminUpdateContents();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}
		}
	}

	public void menuMemberAdmin() {
		while (true) {
			System.out.println("=== 회원 관리자 ===");
			System.out.println(" [ 1.회원 목록 ] [ 2. 주문목록 ] [ 0. 뒤로가기 ]");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				memberController.adminPrintMemberList();
			} else if (sel == 2) {
				System.out.println(" === 구매 목록 ===");
				cartController.adminPrintPurchaseItemList();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}

		}
	}

	public void menuItemAdim() {
		while (true) {
			System.out.println("=== 아이템 관리자 ===");
			System.out.println(" [ 1. 상품전체 출력 ] [ 2.아이템 추가 ] [ 3.아이템 삭제 ] [ 0. 뒤로가기 ]");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				itemController.adminPrintItemList();
			} else if (sel == 2) {
				itemController.adminAddItem();
			} else if (sel == 3) {
				itemController.adminDeliteItem();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}
		}
	}

	public void menuCartAdmin() {
		while (true) {
			System.out.println("=== 장바구니 관리자 ===");
			System.out.println(" [ 1.장바구니 전체출력 ] [ 0. 뒤로가기 ]");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				cartController.printAllCartList();
			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}
		}
	}
}

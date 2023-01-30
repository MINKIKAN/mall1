package S07_Board;

import java.util.ArrayList;
import java.util.Scanner;

import S01_MyUtil.Util;
import S02_Mall.MallController;
import S03_Member.MemberController;
import S05_Admin.AdminController;

public class BoardController {
	private BoardController() {
	}

	static private BoardController instance = new BoardController();

	static public BoardController getInstance() {
		return instance;
	}

	private MallController mallController;
	private Scanner sc;

	BoardDAO boardDAO;

	public void init(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
		if (this.boardDAO == null) {
			boardDAO = new BoardDAO();
		}

		mallController = MallController.getInstance();

		sc = Util.sc;
		boardDAO.setSample();
	}

	public void boardmenu() {
		System.out.println("test=" + boardDAO);
		while (true) {
			System.out.println("=== 게시판 ===");
			boardDAO.printBoardList();
			System.out.println(" [1. 글 쓰기 ] [ 2. 글 삭제 ] [3. 글 수정 ] [ 0. 뒤로가기 ]");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				System.out.println(" 제목 입력 : ");
				String title = sc.next();
				System.out.println(" 내용 입력 : ");
				String contents = sc.next();
				int number = boardDAO.getNextNumber();
				String id = mallController.getMemberLoginId();
				Board board = new Board(number, id, title, contents);
				boardDAO.addContents(board);
			} else if (sel == 2) {
				System.out.println(" 삭제 하실 게시글 번호를 입력 하시오.");
				int listNum = sc.nextInt();

				boardDAO.deliteContents(listNum, mallController.getMemberLoginId());

			} else if (sel == 3) {

				System.out.println(" 수정 하실 게시글 번호를 입력 하시오.");
				int listNum = sc.nextInt();

				boardDAO.updateContents(listNum, mallController.getMemberLoginId());

			} else {
				System.err.println(" 입력 오류 ");
				continue;
			}
		}
	}

	public void adminPrintBoadList() {
		boardDAO.printBoardList();
	}

	public void adminAddContent() {
		System.out.println(" 제목 입력 : ");
		String title = Util.sc.next();
		System.out.println(" 내용 입력 : ");
		String contents = Util.sc.next();
		int number = boardDAO.getNextNumber();
		String id = mallController.getMemberLoginId();
		boardDAO.addAdminBoard(number, mallController.getMemberLoginId(), title, contents);
	}

	public void deliteAdminContents() {
		System.out.println(" 삭제 하실 게시글 번호를 입력 하시오.");
		int listNum = Util.sc.nextInt();
		boardDAO.deliteAdmin(listNum, mallController.getMemberLoginId());
	}

	public void adminUpdateContents() {
		System.out.println(" 수정 하실 게시글 번호를 입력 하시오.");
		int listNum = Util.sc.nextInt();
		boardDAO.adminUpdate(listNum, mallController.getMemberLoginId());
	}
}

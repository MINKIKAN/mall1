package S07_Board;

import java.util.ArrayList;
import java.util.Scanner;

import S01_MyUtil.Util;
import S02_Mall.MallController;
import S03_Member.MemberController;
import S05_Admin.AdminController;

public class BoardController {
       private BoardController () {}
       static private BoardController instance= new BoardController();
       static public BoardController getInstance() {
    	   return instance;
       }
       private MemberController memberController;
       private AdminController adminController;
       
       private MallController mallController;
       private Scanner sc;
       private String memberLoginId;
       BoardDAO boardDAO;
       
       public void init(BoardDAO boardDAO ) {
    	 this.boardDAO = boardDAO;
    	 if(this.boardDAO == null) {
    		 boardDAO = new BoardDAO();
    	 }
    	 memberController = MemberController.getInstance();
    	 adminController = AdminController.getInstance();
    	 mallController = MallController.getInstance();
    	 memberLoginId =null;
    	 sc=Util.sc;
    	   boardDAO.setSample();
       }
 
       public void boardmenu() {
    	   System.out.println("test=" + boardDAO);
       	while(true) {
       		System.out.println("=== 게시판 ===");
       		boardDAO.printBoardList();
       		System.out.println(" [1. 글 쓰기 ] [ 2. 글 삭제 ] [3. 글 수정 ] [ 0. 뒤로가기 ]");
       		int sel=sc.nextInt();
       		if(sel==0) {
       			break;
       		}else if(sel==1) {
   			          System.out.println(" 제목 입력 : " );
   			          String title =sc.next();
   			          System.out.println(" 내용 입력 : ");
   			          String contents =sc.next();
   			          int number= boardDAO.getNextNumber();
   			          String id= mallController.getMemberLoginId();
   			          Board board= new Board(number , id, title ,contents);
   			          boardDAO.addContents(board);
   			}else if(sel==2) {
   				ArrayList<Board> oneBoardList = boardDAO.getOneBoardList(mallController.getMemberLoginId());
   				for(int i=0; i<oneBoardList.size(); i++) {
   					System.out.println(oneBoardList.get(i).getListNumber()+"  "+oneBoardList.get(i).getTitle());
   				}
   				System.out.println(" 삭제 하실 게시글 번호를 입력 하시오.");
   				int listNum=sc.nextInt();
   				boardDAO.deliteContents(listNum);
   			}else if(sel==3) {
   				ArrayList<Board> oneBoardList = boardDAO.getOneBoardList(mallController.getMemberLoginId());
   				for(int i=0; i<oneBoardList.size(); i++) {
   					System.out.println(oneBoardList.get(i).getListNumber()+"  "+oneBoardList.get(i).getTitle());
   				}
   				System.out.println(" 수정 하실 게시글 번호를 입력 하시오.");
   				int listNum=sc.nextInt();
   				boardDAO.updateContents(listNum);
   			}else {
   				System.err.println(" 입력 오류 ");
   				continue;
   			}
       	}
       }
    	   public void adminPrintBoadList () {
    		   boardDAO.printBoardList();
    	   }
       public void adminAddContent () {
    	   System.out.println(" 제목 입력 : " );
	          String title =sc.next();
	          System.out.println(" 내용 입력 : ");
	          String contents =sc.next();
	          int number= boardDAO.getNextNumber();
	          String id= mallController.getMemberLoginId();
	          Board board= new Board(number , id, title ,contents);
	          boardDAO.addContents(board);
       }
       public void deliteAdminContents () {
    	   for(int i=0; i<boardDAO.boardList.size(); i++) {
					System.out.println(boardDAO.boardList.get(i).getListNumber()+"  "+boardDAO.boardList.get(i).getTitle());
				}
				System.out.println(" 삭제 하실 게시글 번호를 입력 하시오.");
				int listNum=sc.nextInt();
				boardDAO.deliteContents(listNum);
       }
       public void adminUpdateContents () {
    	   ArrayList<Board> oneBoardList = boardDAO.getOneBoardList(mallController.getMemberLoginId());
				for(int i=0; i<oneBoardList.size(); i++) {
					System.out.println(oneBoardList.get(i).getListNumber()+"  "+oneBoardList.get(i).getTitle());
				}
				System.out.println(" 수정 하실 게시글 번호를 입력 하시오.");
				int listNum=sc.nextInt();
				boardDAO.updateContents(listNum);
       }
}

       
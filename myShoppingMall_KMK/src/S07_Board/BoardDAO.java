package S07_Board;

import java.util.ArrayList;
import java.util.Scanner;

import S01_MyUtil.Util;

public class BoardDAO {
    public ArrayList<Board> boardList;
    private int listNumber;
	
    public BoardDAO(){
        System.out.println("생성자 호출");
    	boardList =new ArrayList<Board>();
	    listNumber=1000;
    }
    
//    public BoardDAO() {
//    	boardList =new ArrayList<Board>();
//	    listNumber=1000;
//	   
//	}
	
    public void setSample () {
    	Board boards = new Board(getNextNumber(), "admin", "공지사항" ,"욕설 안됩니다.");
    	boardList.add(boards);
    }
    
    public int getNextNumber() {
    	listNumber+=1;
    	return listNumber;
    }
    
    public void addContents (Board board) {
    	boardList.add(board);
    }
    
    public void printBoardList() {
    	for(int i=0; i<boardList.size(); i++) {
    		System.out.print(boardList.get(i).toString()+"\n");
    	}
    }
    public ArrayList<Board> getOneBoardList(String MemberLoginId){
    	ArrayList<Board> oneBoardList = new ArrayList<Board>();
    	for(int i=0; i<boardList.size(); i++) {
    		if(boardList.get(i).getMemberId().equals(MemberLoginId)) {
    			oneBoardList.add(boardList.get(i));
    		}
    	}
    	return oneBoardList;
    }
    public void printOneBoardList (ArrayList<Board> oneBoardList) {
    	for(int i=0; i<oneBoardList.size(); i++) {
    		System.out.println(i+1+")"+oneBoardList.get(i).getTitle());
    	}
    }
    public void deliteContents (int listNum) {
    	int idx=-1;
    	for(int i=0; i<boardList.size(); i++) {
    	 if(boardList.get(i).getListNumber()==listNum) {
    		 idx=i;
    	 }
    	}
    	if(idx==-1) {
    		System.err.println("해당 번호 게시글이 존재하지 않습니다.");
    		return;
    	}else {
			boardList.remove(idx);
			System.out.println(" [ 게시글 삭제 완료 ] ");
		}
    }
    public void updateContents (int listNum ) {
    	int idx=-1;
    	for(int i=0; i<boardList.size(); i++) {
    	 if(boardList.get(i).getListNumber()==listNum) {
    		 idx=i;
    	 }
    	}
    	if(idx==-1) {
    		System.err.println("해당 번호 게시글이 존재하지 않습니다.");
    		return;
    	}else {
    		Board board = boardList.get(idx);
    		System.out.println(" 수정할 내용을 입력하시오");
    		String update = Util.sc.next();
    		board.setContent(update);
			boardList.set(idx, board);
			System.out.println(" [ 게시글 수정 완료 ] ");
		}
    	
    }
}

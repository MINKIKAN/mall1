package S07_Board;


public class Board {
   private int listNumber;
   private String memberId;
   private String title;
   private String content;
   
   public Board() {}

public Board(int listNumber, String memberId, String title, String content) {
	super();
	this.listNumber = listNumber;
	this.memberId = memberId;
	this.title = title;
	this.content = content;
}

public int getListNumber() {
	return listNumber;
}

public void setListNumber(int listNumber) {
	this.listNumber = listNumber;
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

@Override
public String toString() {
	return "[글 번호=" + listNumber +"]\n"+
"[ 작성자=" + memberId +"]\n"+ 
" [제목 " + title + "] \n"+" [내용] \n" + content;
			
}


}

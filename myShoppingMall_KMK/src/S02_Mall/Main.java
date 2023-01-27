package S02_Mall;

import S01_MyUtil.Util;
import S03_Member.MemberController;
import S03_Member.MemberDAO;
import S04_ltem.ItemController;
import S04_ltem.ItemDAO;
import S05_Admin.AdminController;
import S06_Cart.CartController;
import S06_Cart.CartDAO;
import S07_Board.Board;
import S07_Board.BoardController;
import S07_Board.BoardDAO;

public class Main {

	public static void main(String[] args) {
		MallController.getInstance().init();
		AdminController.getInstance().init();
		MemberController.getInstance().init(new MemberDAO());
        ItemController.getInstance().init(new ItemDAO());
        CartController.getInstance().init(new CartDAO());
        MallController.getInstance().menumall();
        BoardController.getInstance().init(new BoardDAO());
        Util.sc.close();
	}

}

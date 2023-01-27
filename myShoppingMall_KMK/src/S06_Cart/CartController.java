package S06_Cart;

import java.util.ArrayList;
import java.util.Scanner;

import S01_MyUtil.Util;
import S02_Mall.MallController;
import S04_ltem.Item;

public class CartController {
    private CartController() {}
    static private CartController instance = new CartController();
    static public CartController getInstance() {
    	return instance;
    	
    }
    private CartDAO cartDAO;
    private Scanner sc;
    private MallController mallController;
    
    public void init(CartDAO cartDAO) {
    	this.cartDAO= cartDAO;
    	sc=Util.sc;
    	mallController = MallController.getInstance();
    }
    public void insertCart(Item item) {
    	Cart cart =new Cart();
    	cart.setNumber(cartDAO.getCartNumber());
    	cart.setMemberID(mallController.getMemberLoginId());
    	cart.setItemName(item.getItemName());
    	cart.setItemPrice(item.getPrice());
    	cartDAO.insertCart(cart);
    }
    
    public void menuCart() {
    	while(true) {
    		System.out.println("===[장바구니 관리]===");
    		System.out.println("1)장바구니출력 2) 구입 3) 삭제 0) 뒤로가기");
    		int sel =sc.nextInt();
    		if(sel==0) {
    			break;
    		}else if(sel==1) {
    			ArrayList<Cart> oneCartList= cartDAO.getOneCartList(mallController.getMemberLoginId());
    			for(int i=0; i<oneCartList.size(); i++) {
    				System.out.println(oneCartList.toString());
    			}
    		}else if(sel==2) {
    			cartDAO.buy(mallController.getMemberLoginId());
    		}else if(sel==3) { 
    		
    		}else {
				System.err.println(" 입력 오류 ");
				continue;
			}
    	}
    }
    public void printAllCartList() {
    	cartDAO.printAllCartList();
    }
    public void adminPrintPurchaseItemList () {
    	for(int i=0; i<cartDAO.orderList.size(); i++) {
    		System.out.println(cartDAO.orderList.get(i).toString());
    	}
    }
    
}

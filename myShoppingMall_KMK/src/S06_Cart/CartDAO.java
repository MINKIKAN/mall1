package S06_Cart;

import java.util.ArrayList;

public class CartDAO {

	public ArrayList<Cart> orderList;
	private ArrayList<Cart> cartList;
	private int cartNumber;
	
	public CartDAO() {
		cartList =new ArrayList<Cart>();
		orderList =new ArrayList<Cart>();
		cartNumber =1000;
	}
	public int getCartNumber() {
		cartNumber+=1;
		return cartNumber;
	}
	
	public void insertCart(Cart cart) {
		cartList.add(cart);
	}
	public ArrayList<Cart> getOneCartList(String MemberLoginId) {
		ArrayList<Cart> oneCartList = new ArrayList<Cart>();
		
		for(int i=0; i< cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(MemberLoginId)) {
				oneCartList.add(cartList.get(i));
			}
		}
		return oneCartList;
	}
	public void printOneCartList(ArrayList<Cart> oneCartList) {
		for(int i=0; i<oneCartList.size(); i++) {
			System.out.println(i+ 1+")"+ oneCartList.get(i));
		}
	}
	public  void purchaseItemList (String MemberLoginId){
		ArrayList<Cart> boughtList =getOneCartList(MemberLoginId);
		if(boughtList==null) {
			return;
		}else {
			for(int i=0; i<getOneCartList(MemberLoginId).size(); i++) {
				boughtList.add(getOneCartList(MemberLoginId).get(i));
			}
			orderList= boughtList;
		}
		
	}
	public void printAllCartList() {
		for(int i=0; i< cartList.size(); i++) {
			System.out.println(i+1+")"+cartList.get(i));
		}
	}
    public void buy(String MemberLoginId) {
    	System.out.println(" 구입이 완료 되었습니다.");
		
    	for(int i=0; i< cartList.size(); i++) {
			if(cartList.get(i).getMemberID().equals(MemberLoginId)) {
				orderList.add(cartList.get(i));
				cartList.remove(i);
				i--;
			}
		}
		
		
		    }
}

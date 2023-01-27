package S04_ltem;

import java.util.ArrayList;
import java.util.Scanner;

import S01_MyUtil.Util;
import S06_Cart.CartController;

public class ItemController {
      private ItemController() {}
      static private ItemController instance = new ItemController();
      static public ItemController getInstance() {
    	  return instance;
      }
      Scanner sc;
      ItemDAO itemDAO;
      CartController cartController;
      
      public void init(ItemDAO itemDAO) {
    	  this.itemDAO =itemDAO;
    	  sc= Util.sc;
    	  cartController = CartController.getInstance();
    	 itemDAO. setSempleData();
      }
      public void adminAddItem() {
    	  System.out.println("[아이템추가] 카테고리 입력 :  ");
    	  String categoryName = sc.next();
    	  
    	  System.out.println("[아이템추가] 아이템이름 입력 :  ");
    	  String itemName=sc.next();
    	  boolean check =itemDAO.checkItemName(itemName);
    	  System.out.println(check);
    	  if(check==true) {
    		  System.err.println("[이미 물건이 게시 되어 있습니다.]");
    		  return;
    	  }
    	  
    	  System.out.println("[아이템추가] 가격입력 :  ");
    	  int price =sc.nextInt();
    	  int number=itemDAO.getNextItemNumber();
    	  
    	  Item item = new Item(number, categoryName,itemName,  price);
    	  itemDAO.addItem(item);
    	  System.out.println("[ 아이템이 성공적으로 추가 되었습니다 ]");
    	  
      }
      public void adminDeliteItem() {
    	  System.out.println("[아이템 삭제] 아이템 번호 입력 :  ");
    	  int delItemNumber = sc.nextInt();
    	  itemDAO.getDeliteItemNumber(delItemNumber);
    	  
      }
      public void adminPrintItemList() {
    	  itemDAO.printItemList();
      }
      public void adminPrintOneCategoryItemList(ArrayList<Item> cateArrayList) {
    	  itemDAO.printItemList(cateArrayList);
      }
      
      public void menuShop() {
    	  ArrayList<String>categoryList = itemDAO.getCategoryList();
    	  while(true) {
    		  System.out.println("===[카테고리]===");
    		  printCategoryList(categoryList);
    		  System.out.println("0) 뒤로가기");
    		  int sel =sc.nextInt();
    		  if(sel==0) {
    			  break;
    		  }
    		  sel-=1;
    		  menuItemList(categoryList.get(sel));
    	  }
      }
      
      public void printCategoryList(ArrayList<String>categoryList) {
    	  for(int i=0; i< categoryList.size(); i++) {
    		  System.out.println(i+1+")"+categoryList.get(i));
    	  }
      }
      public void menuItemList(String category) {
    	  ArrayList<Item>categoryList = itemDAO.getCategoryItemList(category);
    	  while(true) {
    		  System.out.println("===["+category+"]===");
    		  adminPrintOneCategoryItemList(categoryList);
    		  System.out.println("0) 뒤로가기");
    		  int sel =sc.nextInt();
    		  if(sel==0) {
    			  break;
    		  }
    		  Item item =categoryList.get(sel-1);
    		  cartController.insertCart(item);
    	  }
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
}

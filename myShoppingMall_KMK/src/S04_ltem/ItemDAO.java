package S04_ltem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class ItemDAO {

	private ArrayList<Item> itemList;
	private int itemNumber ;
	public ItemDAO() {
		itemList = new ArrayList<Item>();
		itemNumber =1000;
		
	}
	public void setSempleData() {
		String categoryData[] = {"과자","과자", "음료수", "음료수"};
		String itemNameData[] = {"새우깡","감자깡","콜라","사이다"};
		int priceData[] = {1000, 1500, 2000, 2500};
		for(int i=0; i<categoryData.length; i++) {
			Item item= new Item(getNextItemNumber(), categoryData[i], itemNameData[i], priceData[i]);
		itemList.add(item);
		}
	}
	public int getNextItemNumber() {
		itemNumber++;
		return itemNumber;
	}
	public boolean checkItemName(String itemName) {
		for(int i=0; i< itemList.size(); i++) {
			if(itemList.get(i).getItemName().toString().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
	public void addItem(Item item) {
		itemList.add(item);
	}
	public void printItemList() {
		for(int i=0; i<itemList.size(); i++) {
			System.out.println(i + 1+ ")"+ itemList.get(i));
		}
	}
	public void printItemList(ArrayList<Item>itemList) {
		for(int i=0; i<itemList.size(); i++) {
			System.out.println(i + 1+ ")"+ itemList.get(i));
		}
	}
	
	public ArrayList<String> getCategoryList(){
	
	TreeSet<String> categorySet=new TreeSet<String>();
	
	for(int i=0; i<itemList.size(); i++) {
		categorySet.add(itemList.get(i).getCategoryName());
		
	}
	ArrayList<String> categoryList = new ArrayList<String>();
	Iterator<String> iter = categorySet.iterator();
	while(iter.hasNext()) {
		categoryList.add(iter.next());
	}
	return categoryList;
	}
	
	public ArrayList<Item> getCategoryItemList(String category){
		ArrayList<Item> categoryItemList = new ArrayList<Item>();
		for(int i=0; i< itemList.size(); i++) {
			Item item = itemList.get(i);
			if(category.equals(item.getCategoryName())) {
				categoryItemList.add(item);
			}
		}
		return categoryItemList;
	}
	
	public void getDeliteItemNumber(int number){
		int idx=-1;
		for(int i=0; i<itemList.size(); i++) {
			if(itemList.get(i).getNumber()==number) {
			idx=i;
			
		}
		}
			if (idx!=-1) {
				itemList.remove(idx);
				
			}else {
				System.err.println("해당 아이템이 없습니다");
				return;
			}
		
	
	
	}
	
	
	
	
	
	
	
}

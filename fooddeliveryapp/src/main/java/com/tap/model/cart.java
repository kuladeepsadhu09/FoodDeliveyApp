package com.tap.model;

import java.util.LinkedHashMap;

public class cart {
	LinkedHashMap<Integer, cartitem>items= new LinkedHashMap<Integer, cartitem>();
	public void add(cartitem item) {
		int itemsid=item.getItemId();
		if(items.containsKey(itemsid)) {
			cartitem existingitem=items.get(itemsid);
			existingitem.setQuaninty(existingitem.getQuaninty()+item.getQuaninty());
		}
		else {
			items.put(itemsid,item);
		}
	}
	public void update(int itemid,int quantity) {
		if(items.containsKey(itemid)) {
			if(quantity<=0) {
				items.remove(itemid);
			}
			else {
				Integer it=itemid;
				items.get(it).setQuaninty(quantity);
				
			}
		}
	}
	public void remove(int itemid) {
		items.remove(itemid);
	}
	   
	public LinkedHashMap<Integer, cartitem> getItems(){
		return items;
	}

}

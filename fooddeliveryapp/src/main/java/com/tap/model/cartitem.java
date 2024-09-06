package com.tap.model;

public class cartitem {
	private int itemId;
	private int restrantId;
	private String name;
	private double price;
	private int quaninty;
	private double subtotal;
	private String imgepath;
	
	public cartitem() {
		super();
	}


	public cartitem(int itemId, int restrantId, String name, double price, int quaninty, double subtotal,String imgepath) {
		super();
		this.itemId = itemId;
		this.restrantId = restrantId;
		this.name = name;
		this.price = price;
		this.quaninty = quaninty;
		this.subtotal = subtotal;
		this.imgepath=imgepath;
	}


	public String getImgepath() {
		return imgepath;
	}


	public void setImgepath(String imgepath) {
		this.imgepath = imgepath;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getRestrantId() {
		return restrantId;
	}


	public void setRestrantId(int restrantId) {
		this.restrantId = restrantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuaninty() {
		return quaninty;
	}


	public void setQuaninty(int quaninty) {
		this.quaninty = quaninty;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	@Override
	public String toString() {
		return "cartitem [itemId=" + itemId + ", restrantId=" + restrantId + ", name=" + name + ", price=" + price
				+ ", quaninty=" + quaninty + ", subtotal=" + subtotal + "]";
	}
	
	

}

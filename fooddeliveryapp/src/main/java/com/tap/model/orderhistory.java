package com.tap.model;

public class orderhistory {
	private int orderhistoryid;
	private int orderId;
	private int userId;
	private double totalAmount;
	private String status;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public orderhistory() {
		super();
	}
	public orderhistory(int orderhistoryid, int orderId, int userId, double totalAmount, String status) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public orderhistory(int orderId, int userId, double totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	public orderhistory(int orderhistoryid, int orderId, int userId, double totalAmount, String status, String date) {
		super();
		this.orderhistoryid = orderhistoryid;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.date = date;
	}
	public int getOrderhistoryid() {
		return orderhistoryid;
	}
	public void setOrderhistoryid(int orderhistoryid) {
		this.orderhistoryid = orderhistoryid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "orderhistory [orderhistoryid=" + orderhistoryid + ", orderId=" + orderId + ", userId=" + userId
				+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	
}

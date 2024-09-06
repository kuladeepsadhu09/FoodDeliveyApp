package com.tap.model;

public class order {
	private int orderId;
	private int resturantId;
	private int userId;
	private double totalAmount;
	private String status;
	public order() {
		super();
	}
	public order(int orderId, int resturantId, int userId, double totalAmount, String status) {
		super();
		this.orderId = orderId;
		this.resturantId = resturantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public order(int resturantId, int userId, double totalAmount, String status) {
		super();
		this.resturantId = resturantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
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
		return "order [orderId=" + orderId + ", resturantId=" + resturantId + ", userId=" + userId + ", totalAmount="
				+ totalAmount + ", status=" + status + "]";
	}
	
}

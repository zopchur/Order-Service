package com.example.ansh.beans;

public class Orders {

	private String orderId;
	private String orderQty;
	private String productId;
	
	private Product product;

	public Orders() {}
	public Orders(String orderId, String orderQty, String productId) {
		super();
		this.orderId = orderId;
		this.orderQty = orderQty;
		this.productId = productId;
	}
	public Orders(String orderId, String orderQty, Product product) {
		super();
		this.orderId = orderId;
		this.orderQty = orderQty;
		this.product = product;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}

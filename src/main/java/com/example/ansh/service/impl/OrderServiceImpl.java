package com.example.ansh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ansh.beans.Orders;
import com.example.ansh.beans.Product;
import com.example.ansh.proxy.ProductServiceProxy;
import com.example.ansh.service.OrderService;
import com.example.ansh.util.OrderConstant;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private ProductServiceProxy productServiceProxy;
	
	@Override
	public Orders getOrdersDetail(String orderId) {
		Orders orders = OrderConstant.ordersMap.get(orderId);
		
		if(orders!=null) {
			Product product = productServiceProxy.getProductDetail(orders.getProductId());
			orders.setProduct(product);
		}
		return orders;
	}
}

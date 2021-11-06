package com.example.ansh.util;

import java.util.HashMap;
import java.util.Map;

import com.example.ansh.beans.Orders;

public class OrderConstant {

	public static Map<String, Orders> ordersMap = new HashMap<>();
	
	static {
		ordersMap.put("OR1001", new Orders("OR1001", "10", "P1001"));
		ordersMap.put("OR1002", new Orders("OR1002", "2", "P1002"));
		ordersMap.put("OR1003", new Orders("OR1003", "13", "P1003"));
		ordersMap.put("OR1004", new Orders("OR1004", "9", "P1004"));
	}
}

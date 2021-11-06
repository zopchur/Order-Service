package com.example.ansh.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ansh.beans.Orders;
import com.example.ansh.beans.Product;
import com.example.ansh.beans.ResponseInfo;
import com.example.ansh.service.OrderService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod = "getOrdersDetailfallBackResponse")
	public ResponseInfo getOrdersDetail(@PathVariable String orderId) {
		ResponseInfo response = new ResponseInfo();
		
		Orders orders = orderService.getOrdersDetail(orderId);
		
		response.setData(orders);
		response.setStatusCode(HttpStatus.OK.toString());
		response.setMessage("Success");
		
		return response;
	}
	
	public ResponseInfo getOrdersDetailfallBackResponse(String orderId, Throwable t) {
		ResponseInfo response = new ResponseInfo();
		response.setStatusCode(HttpStatus.NOT_FOUND.toString());
		response.setMessage("Failure Message "+ t.getMessage());
		return response;
	}
}

package com.backend.services;


import org.springframework.stereotype.Service;

import com.backend.model.OrderItem;
import com.backend.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;
	}
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

}


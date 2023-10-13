package com.backend.services;

import com.backend.model.Cart;
import com.backend.model.User;
import com.backend.request.AddItemRequest;
import com.backend.exceptions.ProductException;

public interface CartService {
	
  public Cart createCart(User user);
  
  public String addCartItem (Long userId,AddItemRequest req) throws ProductException;
  
  public Cart findUserCart(Long userId);
}

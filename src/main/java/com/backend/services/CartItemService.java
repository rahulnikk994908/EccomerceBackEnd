package com.backend.services;

import com.backend.exceptions.CartItemException;
import com.backend.exceptions.UserException;
import com.backend.model.Cart;
import com.backend.model.CartItem;
import com.backend.model.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartitem);
	
	public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws CartItemException,UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size,Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException,UserException;
	
	public CartItem findCartItemById(Long cartItemId)throws CartItemException;

}

package com.backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.exceptions.CartItemException;
import com.backend.exceptions.UserException;
import com.backend.model.Cart;
import com.backend.model.CartItem;
import com.backend.model.Product;
import com.backend.model.User;
import com.backend.repository.CartItemRepository;
import com.backend.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	private CartItemRepository cartItemRepository;
	private UserService userService;
	private CartRepository cartRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService,
			CartRepository cartRepository) {
		this.cartItemRepository = cartItemRepository;
		this.userService = userService;
		this.cartRepository = cartRepository;
	}

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());
		
		CartItem createdCartItem =cartItemRepository.save(cartItem);
		
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		CartItem item = findCartItemById(id) ;
		User user = userService.findUserById(item.getUserId());
		
		if(user.getId().equals(userId)) {
			item.setQuantity(cartItem.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(item.getQuantity()*item.getProduct().getDiscountedPrice());
		}
		
		return cartItemRepository.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		CartItem cartItem= cartItemRepository.isCartItemExist(cart, product, size, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException {
		
		System.out.println("userId- "+userId+" cartItemId "+cartItemId);
		
		CartItem cartItem=findCartItemById(cartItemId);
		
		User user=userService.findUserById(cartItem.getUserId());
		User reqUser=userService.findUserById(userId);
		
		if(user.getId().equals(reqUser.getId())) {
			cartItemRepository.deleteById(cartItem.getId());
		}
		else {
			throw new UserException("you can't remove anothor users item");
		}
		
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		Optional<CartItem> opt=cartItemRepository.findById(cartItemId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CartItemException("cartItem not found with id : "+cartItemId);
	}

}

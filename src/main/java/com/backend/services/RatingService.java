package com.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.exceptions.ProductException;
import com.backend.model.Rating;
import com.backend.model.User;
import com.backend.request.RatingRequest;


public interface RatingService {
	
	public Rating createRating(RatingRequest req,User user)throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}

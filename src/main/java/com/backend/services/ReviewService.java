package com.backend.services;

import java.util.List;

import com.backend.exceptions.ProductException;
import com.backend.model.Review;
import com.backend.model.User;
import com.backend.request.ReviewRequest;

public interface ReviewService {
	public Review createReview(ReviewRequest req,User user)throws ProductException;
	public List<Review> getAllReview(Long productId);

}

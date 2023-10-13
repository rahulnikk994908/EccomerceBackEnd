package com.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.exceptions.ProductException;
import com.backend.model.Product;
import com.backend.model.Review;
import com.backend.model.User;
import com.backend.repository.ProductRepository;
import com.backend.repository.ReviewRepository;
import com.backend.request.ReviewRequest;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private ProductService productService;
	private ProductRepository productRepository;
	
	public ReviewServiceImpl(ReviewRepository reviewRepository,ProductService productService,ProductRepository productRepository) {
		this.reviewRepository=reviewRepository;
		this.productService=productService;
		this.productRepository=productRepository;
	}

	@Override
	public Review createReview(ReviewRequest req,User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product=productService.findProductById(req.getProductId());
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
//		product.getReviews().add(review);
		productRepository.save(product);
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		
		return reviewRepository.getAllProductsReview(productId);
	}

}

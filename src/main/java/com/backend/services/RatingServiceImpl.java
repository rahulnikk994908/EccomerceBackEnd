package com.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.exceptions.ProductException;
import com.backend.model.Product;
import com.backend.model.Rating;
import com.backend.model.User;
import com.backend.repository.RatingRepository;
import com.backend.request.RatingRequest;

@Service
public class RatingServiceImpl implements RatingService {
	private RatingRepository ratingRepository;
	private ProductService productService;

	public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService) {
		this.ratingRepository = ratingRepository;
		this.productService = productService;
	}

	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {
		Product product =productService.findProductById(req.getProductId());
		
		Rating rating = new Rating();
		rating.setProduct(product);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}

}

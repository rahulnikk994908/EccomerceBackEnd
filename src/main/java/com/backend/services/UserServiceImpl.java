package com.backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.config.JwtProvider;
import com.backend.exceptions.UserException;
import com.backend.model.User;
import com.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	

	public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}

	@Override
	public User findUserById(Long userid) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userid);
		
		if(user.isPresent()) {
		return user.get();
	}
		throw new UserException("User not found with id:"+userid);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		// TODO Auto-generated method stub
		String email = jwtProvider.getEmailFromToken(jwt);
		
		User user =userRepository.findByEmail(email);
		if(user==null) {
			throw new UserException("user not found with email"+email);
		}
		return user;
	}

}

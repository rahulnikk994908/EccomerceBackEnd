package com.backend.services;

import com.backend.exceptions.UserException;
import com.backend.model.User;

public  interface UserService {
	
	public User findUserById(Long userid)throws UserException;
	
	public User findUserProfileByJwt(String jwt)throws UserException;


}

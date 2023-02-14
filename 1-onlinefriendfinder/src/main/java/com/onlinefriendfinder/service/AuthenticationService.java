package com.onlinefriendfinder.service;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;

public interface AuthenticationService {

		public User register(User user) throws ResourceNotFoundException;
		public User login(User user) throws ResourceNotFoundException;
		public boolean logout() throws ResourceNotFoundException;

}

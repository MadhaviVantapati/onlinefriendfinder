package com.onlinefriendfinder.service;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;

public interface AdminService {
		
		public User unblockUserAccount( int userId) throws ResourceNotFoundException ;
		public User blockUserAccount( int userId) throws ResourceNotFoundException;


}

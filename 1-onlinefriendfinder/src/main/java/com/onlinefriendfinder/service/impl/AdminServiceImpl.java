package com.onlinefriendfinder.service.impl;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.UserRepository;
import com.onlinefriendfinder.service.AdminService;
	@Service("AdminService")
	public class AdminServiceImpl implements AdminService{
		
		@Autowired
		UserRepository userRepository;

		@Override
		public User unblockUserAccount(int userId)throws ResourceNotFoundException {
			User userFound = userRepository.findById(userId).get();
			userFound.setBlocked(false);
			userRepository.saveAndFlush(userFound);
			return userFound;
		}

		@Override
		public User blockUserAccount(int userId)throws ResourceNotFoundException {
			User bean = null;
			try {
				bean = userRepository.findById(userId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("User details not found!");
			}
			bean.setBlocked(true);
			userRepository.save(bean);
//			userRepository.deleteById(user.getUserId());	
			return bean;
			
		}


}

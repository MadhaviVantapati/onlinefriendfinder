package com.onlinefriendfinder.service.impl;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.AddressRepository;
import com.onlinefriendfinder.repository.UserRepository;
import com.onlinefriendfinder.service.AuthenticationService;


	@Service("AuthenticationService")
	public class AuthenticationServiceImpl implements AuthenticationService{
		
		@Autowired
		UserRepository userRepository;
		@Autowired
		AddressRepository addressRepository;

		@Override
		public User register(User user) throws ResourceNotFoundException{
			addressRepository.save(user.getAddress());
			userRepository.save(user);
			return user;
		}

		@Override
		public User login(User user) throws ResourceNotFoundException{
			User bean = null;
			try {
				for(User i : userRepository.findAll()) {
					if(user.getUsername().equals(i.getUsername())) {
						if(user.getPassword().equals(i.getPassword())) {
							return user;
						}
						throw new ResourceNotFoundException("User details not found! Invalid details");
					}
				}
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("User details not found! Invalid details");
			}
			return null;
		}

		@Override
		public boolean logout() throws ResourceNotFoundException {
			// TODO Auto-generated method stub
			return false;
		}

	}
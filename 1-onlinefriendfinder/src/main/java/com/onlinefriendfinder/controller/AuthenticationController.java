package com.onlinefriendfinder.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.service.AuthenticationService;

import com.onlinefriendfinder.entity.*;

	@RestController
	@RequestMapping("/off-authentication")
	public class AuthenticationController {
		
		@Autowired
		AuthenticationService AuthenticationService;
		
		@PostMapping("/register")
		public User register(@RequestBody User user) throws ResourceNotFoundException{
			return AuthenticationService.register(user);
		}
		
		@GetMapping("/login")
		public User login(@RequestBody User user) throws ResourceNotFoundException{
			return AuthenticationService.login(user);
		}
		
		@GetMapping("/logout")
		public boolean logout() throws ResourceNotFoundException{
			return AuthenticationService.logout();
		}


}

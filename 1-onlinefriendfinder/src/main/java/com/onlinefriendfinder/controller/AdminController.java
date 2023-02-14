package com.onlinefriendfinder.controller;

	import java.time.LocalDate;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.service.AdminService;

	@RestController
	@RequestMapping("/off-admin")
	public class AdminController {
		
		@Autowired
		AdminService adminService;
		
		@PostMapping("/unblockUserAccount/{userId}")
		public User unblockUserAccount(@PathVariable int userId) throws ResourceNotFoundException {
			return adminService.unblockUserAccount(userId);
		}
		
		@DeleteMapping("/blockUserAccount/{userId}")
		public User blockUserAccount(@PathVariable int userId) throws ResourceNotFoundException{
			return adminService.blockUserAccount(userId);
		}

}

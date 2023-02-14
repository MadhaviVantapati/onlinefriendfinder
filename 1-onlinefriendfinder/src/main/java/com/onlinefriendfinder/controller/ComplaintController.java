package com.onlinefriendfinder.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.Complaint;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.service.ComplaintService;

	


	@RestController
	@RequestMapping("/off-complaint")
	public class ComplaintController {
		
		@Autowired
		ComplaintService complaintService;
		
		@PostMapping("/addComplaint/{commentId}/{userId}")
		public Complaint addComplaint(@RequestBody Complaint complaint,@PathVariable int userId,@PathVariable int commentId) throws ResourceNotFoundException{
			return complaintService.addComplaint(complaint, userId,commentId);
		}
		
		@GetMapping("/viewComplaintById/{id}")
		public Complaint viewComplaintById(@PathVariable long id) throws ResourceNotFoundException{
			return complaintService.viewComplaintById(id);
		}
		
		@GetMapping("/viewAllComplaints")
	    public List<Complaint> viewAllComplaints() throws ResourceNotFoundException{
	    	return complaintService.viewAllComplaints();
	    }
		
		@PutMapping("/resolveComplaint")
		public boolean resolveComplaint(@RequestBody Complaint complaint) throws ResourceNotFoundException{
			return complaintService.resolveComplaint(complaint);
		}

}

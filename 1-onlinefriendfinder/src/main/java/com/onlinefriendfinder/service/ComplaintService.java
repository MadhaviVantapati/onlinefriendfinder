package com.onlinefriendfinder.service;

	import java.util.List;

import com.onlinefriendfinder.entity.Complaint;
import com.onlinefriendfinder.exception.ResourceNotFoundException;


	public interface ComplaintService {

		public Complaint addComplaint(Complaint complaint,int userId,int commentId) throws ResourceNotFoundException;
		public Complaint viewComplaintById(long id) throws ResourceNotFoundException;
	    public List<Complaint> viewAllComplaints() throws ResourceNotFoundException;
		public boolean resolveComplaint(Complaint complaint) throws ResourceNotFoundException;


}

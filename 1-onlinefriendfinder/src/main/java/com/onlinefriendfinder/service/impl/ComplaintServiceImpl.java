package com.onlinefriendfinder.service.impl;

	import java.util.ArrayList;
import java.util.List;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.Comment;
import com.onlinefriendfinder.entity.Complaint;
import com.onlinefriendfinder.entity.Post;
import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.CommentRepository;
import com.onlinefriendfinder.repository.ComplaintRepository;
import com.onlinefriendfinder.repository.UserRepository;
import com.onlinefriendfinder.service.ComplaintService;

	
	@Service("ComplaintService")
	public class ComplaintServiceImpl implements ComplaintService{
		@Autowired
		UserRepository userRepository;
		
		@Autowired
		CommentRepository commentRepository;
		
		@Autowired
		ComplaintRepository complaintRepository;

		public Complaint addComplaint(Complaint complaint,int userId,int commentId) throws ResourceNotFoundException{
			User bean=null;
//			Comment comment=null;
			try {
				bean=userRepository.findById((int) userId).get();
//				comment=commentRepository.findById(commentId).get();
				
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("details not found");
			}
		/*	List<Complaint> cms=bean.Complaints();
			if(cms==null) {
				System.out.println("in");
				cms=new ArrayList<>();
			}
			cms.add(complaint);
			User.setComplaints(cms);
			complaint.setComments(comment);
			complaint.setUser(bean);
			*/
			complaint.setUser(bean);
           complaintRepository.saveAndFlush(complaint);
		return complaint;
		}

		@Override
		public Complaint viewComplaintById(long id) throws ResourceNotFoundException{
			Complaint bean = null;
			try {
				bean = complaintRepository.findById((int)id).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Complaint details not found!");
			}
			return bean;
			
		}

		@Override
		public List<Complaint> viewAllComplaints() throws ResourceNotFoundException{
			return complaintRepository.findAll();
		}

		public boolean resolveComplaint(Complaint complaint)throws ResourceNotFoundException {
			Complaint bean = null;
			try {
				bean = complaintRepository.findById(complaint.getComplaintId()).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Complaint details not found!");
			}
			bean.setStatus("Solved");
			return true;
		}
	


}

package com.onlinefriendfinder.service.impl;

	import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.Poll;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.PollRepository;
import com.onlinefriendfinder.service.PollService;

	
	@Service("PollService")
	public class PollServiceImpl implements PollService{
		
		@Autowired
		PollRepository pollRepository;

		public Poll createPoll(Poll poll) throws ResourceNotFoundException{
			pollRepository.saveAndFlush(poll);
			return poll;
		}

		public Poll veiwPollById(long pollId) throws ResourceNotFoundException{
			Poll bean = null;
			try {
				bean = pollRepository.findById((int)pollId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Poll details not found!");
			}
			return bean;
		}

		@Override
		public Poll deletePoll(long pollId) throws ResourceNotFoundException{
			Poll bean = null;
			try {
				bean = pollRepository.findById((int)pollId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Poll details not found!");
			}
			pollRepository.deleteById((int)pollId);
			return bean;
		}

		@Override
		public boolean participatePoll(Poll poll) throws ResourceNotFoundException{

			Poll newPoll = new Poll();
			newPoll.setQuestion(poll.getQuestion());
			newPoll.setCreatedOn(LocalDate.now());
			pollRepository.save(newPoll);
			return true;
		}


}

package com.onlinefriendfinder.service;

import com.onlinefriendfinder.entity.Poll;
import com.onlinefriendfinder.exception.ResourceNotFoundException;

public interface PollService {

		public Poll createPoll(Poll poll) throws ResourceNotFoundException;
		public Poll veiwPollById(long pollId) throws ResourceNotFoundException;
		public Poll deletePoll(long pollId) throws ResourceNotFoundException;
		public boolean participatePoll(Poll poll) throws ResourceNotFoundException;


}

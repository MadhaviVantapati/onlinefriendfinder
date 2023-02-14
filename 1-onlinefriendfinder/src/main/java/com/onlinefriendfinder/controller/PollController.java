package com.onlinefriendfinder.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.Poll;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.service.PollService;



	@RestController
	@RequestMapping("/off-poll")
	public class PollController {
		
		@Autowired
		PollService pollService;
		
		@PostMapping("/createPoll")
		public Poll createPoll(@RequestBody Poll poll) throws ResourceNotFoundException{
			return pollService.createPoll(poll);
		}
		
		@GetMapping("/veiwPollById/{pollId}")
		public Poll veiwPollById(@PathVariable long pollId) throws ResourceNotFoundException{
			return pollService.veiwPollById(pollId);
		}
		
		@DeleteMapping("/deletePoll/{pollId}")
		public Poll deletePoll(@PathVariable long pollId) throws ResourceNotFoundException{
			return pollService.deletePoll(pollId);
		}
		
		@PostMapping("/participatePoll")
		public boolean participatePoll(@RequestBody Poll poll) throws ResourceNotFoundException{
			return pollService.participatePoll(poll);
		}

	
}

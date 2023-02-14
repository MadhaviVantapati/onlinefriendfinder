package com.onlinefriendfinder.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Poll;

	

	@Repository
	public interface PollRepository extends JpaRepository<Poll, Integer>{

}

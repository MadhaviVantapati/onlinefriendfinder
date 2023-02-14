package com.onlinefriendfinder.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.FriendReq;


	@Repository
	public interface FriendReqRepository extends JpaRepository<FriendReq,Integer> {

	

}

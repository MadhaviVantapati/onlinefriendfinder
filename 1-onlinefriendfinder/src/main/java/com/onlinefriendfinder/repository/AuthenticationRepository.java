package com.onlinefriendfinder.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Complaint;


	@Repository
	public interface AuthenticationRepository extends JpaRepository<Complaint,Integer> {


}

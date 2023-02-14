package com.onlinefriendfinder.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Chat;


	@Repository
	public interface ChatRepository  extends JpaRepository<Chat,Integer> {


}

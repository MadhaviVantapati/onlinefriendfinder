package com.onlinefriendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Comment;
import com.onlinefriendfinder.entity.Post;


	@Repository
	public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

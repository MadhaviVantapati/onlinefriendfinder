package com.onlinefriendfinder.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	@Query(value="select * from post_details where user_Id= :userId",nativeQuery = true)
	public List<Post>searchAllPostByUserId(@Param("userId") int userId);


}

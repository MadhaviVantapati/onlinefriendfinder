package com.onlinefriendfinder.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinefriendfinder.entity.Likes;
import com.onlinefriendfinder.entity.Post;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Integer>{

}

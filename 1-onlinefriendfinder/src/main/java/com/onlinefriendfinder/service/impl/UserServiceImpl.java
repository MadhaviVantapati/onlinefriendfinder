package com.onlinefriendfinder.service.impl;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinefriendfinder.entity.Comment;
import com.onlinefriendfinder.entity.FriendReq;
import com.onlinefriendfinder.entity.Likes;
import com.onlinefriendfinder.entity.Post;
import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.CommentRepository;
import com.onlinefriendfinder.repository.FriendReqRepository;
import com.onlinefriendfinder.repository.LikeRepository;
import com.onlinefriendfinder.repository.PostRepository;
import com.onlinefriendfinder.repository.UserRepository;
import com.onlinefriendfinder.service.UserService;




@Service("UserService")
	public class UserServiceImpl implements UserService{
		
		@Autowired
		FriendReqRepository friendReqRepository;
		
		@Autowired
		UserRepository userRepository;
		
		@Autowired
		PostRepository postRepository;
		@Autowired
		CommentRepository  commentRepository;
		
		@Autowired
		LikeRepository likeRepository;
		
		/*public User addNewUserService(User u) { 
		         u=userRepository.save(u);
				return u;
			}*/

		public FriendReq sendFriendRequest(FriendReq req) throws ResourceNotFoundException {
			friendReqRepository.saveAndFlush(req);
			return req;
		}

		public FriendReq acceptFriendRequest(FriendReq req) throws ResourceNotFoundException {
			FriendReq bean = null;
			try {
				bean = friendReqRepository.findById(req.getFriendReqId()).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Friend Request details not found!");
			}
			bean.setAccepted(true);
			bean.setStatus("Accepted");
			return bean;
		}

		@Override
		public List<FriendReq> viewAllReceivedFriendReqest(){
			return friendReqRepository.findAll();
		}

		public List<User> searchFriendByName(String name) throws ResourceNotFoundException {
			List<User> users = new ArrayList<User>();
			try {
				for(User i : userRepository.findAll()) {
					if((( i).getFirstName()+" "+i.getLastName()).equals(name)) {
						System.out.println(i);
						users.add(i);
					}
				}
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("User details not found!");
			}
			return users;
		}
		@Override
		public Post createPost(Post post,int userId) throws ResourceNotFoundException {
			User u=userRepository.findById(userId).get();
	        post.setUser(u);
	        LocalDate date=LocalDate.now();
	        post.setPostedOn(date);
			postRepository.saveAndFlush(post);
			return post;
		}

		@Override
		public Comment addComment(Comment comment, int postId, int userId) throws ResourceNotFoundException {


			Post bean = null;
			User user = null;
			try {
				bean = postRepository.findById((int)postId).get();
				user = userRepository.findById(userId).get();
			}
			catch(Exception e) {
				throw new ResourceNotFoundException("Post details not found!");
			}
			List<Comment> cms = bean.getComments();
			if(cms==null) {
				System.out.println("innn");
				cms=new ArrayList<>();
			}
			cms.add(comment);
			
			bean.setComments(cms);
			comment.setPost(bean);
			comment.setUser(user);
			commentRepository.save(comment);
			return comment;
		}

		public boolean likePost(Boolean isLike,  int postId,int userId) throws ResourceNotFoundException {
			Optional<User> user=userRepository.findById(userId);
			Optional<Post> post=postRepository.findById(postId);
			if(!post.isPresent()) {
				throw new ResourceNotFoundException("post with id"+postId+"not found");
			}
			Post postToLike=post.get();
			Likes like=new Likes();
			like.setLiked(isLike);
			like.setPost(postToLike);
			like.setUser(user.get());
			likeRepository.save(like);
			return isLike;
			
		}

		public List<Post> getPostByUserIdService(int userId) {
		    List<Post> p=postRepository.searchAllPostByUserId(userId);
			return  p;
		}

		@Override
		public void removePostByUserIdService(int postId) {
			postRepository.deleteById(postId);
			// TODO Auto-generated method stub
	
		}

		
		public void removeCommentByPostId(Comment comment, int postId) {
			// TODO Auto-generated method stub
			commentRepository.deleteById(postId);
		}}
			
	

		

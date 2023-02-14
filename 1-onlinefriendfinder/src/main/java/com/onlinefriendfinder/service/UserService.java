package com.onlinefriendfinder.service;

	import java.util.List;

import org.springframework.data.repository.query.Param;

import com.onlinefriendfinder.entity.Comment;
import com.onlinefriendfinder.entity.FriendReq;
import com.onlinefriendfinder.entity.Post;
import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;

	

	public interface UserService {
		
		public FriendReq sendFriendRequest(FriendReq req) throws ResourceNotFoundException;
		public FriendReq acceptFriendRequest(FriendReq req) throws ResourceNotFoundException;
		public List<FriendReq> viewAllReceivedFriendReqest() throws ResourceNotFoundException;  
		public List<User>searchFriendByName(String name) throws ResourceNotFoundException;
		public Post createPost(Post post,int userId) throws ResourceNotFoundException;
		public Comment addComment(Comment comment, int postId, int userId) throws ResourceNotFoundException;
		public boolean likePost(Boolean isLike, int postId,int userId) throws ResourceNotFoundException;
		//public User addNewUserService(User u);
		List<Post> getPostByUserIdService(int userId);
		public void removePostByUserIdService(int postId);
		public void removeCommentByPostId(Comment comment,int postId);


}

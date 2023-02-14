package com.onlinefriendfinder.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.onlinefriendfinder.entity.Comment;
import com.onlinefriendfinder.entity.FriendReq;
import com.onlinefriendfinder.entity.Post;
import com.onlinefriendfinder.entity.User;
import com.onlinefriendfinder.exception.ResourceNotFoundException;
import com.onlinefriendfinder.repository.PostRepository;
import com.onlinefriendfinder.service.UserService;



	@RestController
	@RequestMapping("/off")
	public class UserController {
		@Autowired
		UserService userService;

		
		
		@PostMapping("/sendFriendRequest")
		public FriendReq sendFriendRequest(@RequestBody FriendReq req) throws ResourceNotFoundException{
			return userService.sendFriendRequest(req);
		}
		
		@PutMapping("/acceptFriendRequest")
		public FriendReq acceptFriendRequest(@RequestBody FriendReq req) throws ResourceNotFoundException{
			return userService.acceptFriendRequest(req);
		}
		
		@GetMapping("/viewAllReceivedFriendReqest")
		public List<FriendReq> viewAllReceivedFriendReqest() throws ResourceNotFoundException{
			return userService.viewAllReceivedFriendReqest();
		}
		
		@GetMapping("/searchFriendByName/{name}")
		public List<User> searchFriendByName(@PathVariable String name) throws ResourceNotFoundException{
			return userService.searchFriendByName(name);
		}
		
		@PostMapping("/createPost/{userId}")
		public Post createPost(@RequestBody Post post,@PathVariable int userId) throws ResourceNotFoundException{
			return userService.createPost(post,userId);
		}
		
		@PutMapping("/addComment/{postId}/{userId}")
		public Comment addComment(@RequestBody Comment comment, @PathVariable int postId, @PathVariable int userId) throws ResourceNotFoundException{
			return userService.addComment(comment, postId, userId);
		}
		
		@PostMapping("/likePost/{isLike}/{postId}/{userId}")
		public ResponseEntity<?> likePost(@PathVariable Boolean isLike,@PathVariable int postId,@PathVariable int userId) throws ResourceNotFoundException{
			try {
				boolean liked=userService.likePost(isLike,postId,userId);
				return ResponseEntity.ok(liked);
			}
			catch(ResourceNotFoundException ex) {
				return ResponseEntity.notFound().build();
			}
			//return userService.likePost(isLike, userId);
		}
		@GetMapping("/allposts/{userId}")
		public List<Post> searchAllPostByUserId(@PathVariable int userId){
			return userService.getPostByUserIdService(userId);
			
		}
		@DeleteMapping("/delete/{postId}")
		public String removePostByUserId(@PathVariable("postId") int userId) {
			userService.removePostByUserIdService(userId);
			return "deleted";
		}
		/*@DeleteMapping("/deletecomment/{postId}")
		public String removeCommentByPostId(@PathVariable("postId") int userId) {
			userService.removeCommentByPostId(postId, userId);
			return "deleted";
		}*/
	}




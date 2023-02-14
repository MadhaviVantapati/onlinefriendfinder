package com.onlinefriendfinder.entity;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	public class Likes {

		@Id
		@GeneratedValue//(strategy //= GenerationType.IDENTITY)
		private int likeId;
		private boolean isLiked;
		
		@ManyToOne//(fetch = FetchType.LAZY )
		@JoinColumn(name = "user_id")//, referencedColumnName = "userId")
		private User user;
		
		@OneToOne
		@JoinColumn(name="post_id")
		private Post post;
  
		/*public Likes() {
			super();
		}

		public Likes(int likeId, boolean isLiked, User user) {
			super();
			this.likeId = likeId;
			this.isLiked = isLiked;
			this.user = user;
		}*/

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

		public int getLikeId() {
			return likeId;
		}

		public void setLikeId(int likeId) {
			this.likeId = likeId;
		}

		public boolean isLiked() {
			return isLiked;
		}

		public void setLiked(boolean isLiked) {
			this.isLiked = isLiked;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		
		

}

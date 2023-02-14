package com.onlinefriendfinder.entity;


	import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import org.hibernate.annotations.Fetch;
	import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
	import com.fasterxml.jackson.databind.annotation.JsonSerialize;
	import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
	import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

	@Entity
	@Table(name="post_details")
	public class Post {

		@Id
		@GeneratedValue
		private int postId;
		private String text;
		private String photo;
		
		//@JsonDeserialize(using = LocalDateDeserializer.class)
		//@JsonSerialize(using = LocalDateSerializer.class)
		@JsonIgnore
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
		private LocalDate postedOn;
		@ManyToOne
		@JoinColumn(name = "user_id")//referencedColumnName = "userId")
		//@JsonBackReference("userRef")
		private User user;
		
		//@OneToMany(mappedBy = "post" , fetch = FetchType.EAGER)
		//@JsonBackReference("userCommand")
		//private List<Comment> comments;
		//private List<Post> posts;
		

		/*(public Post() {
			super();
		}*/

		

		/*public List<Post> getPosts() {
			return posts;
		}

		public void setPosts(List<Post> posts) {
			this.posts = posts;
		}*/

		public int getPostId() {
			return postId;
		}

		public void setPostId(int postId) {
			this.postId = postId;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public LocalDate getPostedOn() {
			return postedOn;
		}

		public void setPostedOn(LocalDate postedOn) {
			this.postedOn = postedOn;
		}

		public User getUser() {
			return user;
		}

	   public void setUser(User user) {
			this.user = user;
		}

	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setComments(List<Comment> cms) {
		// TODO Auto-generated method stub
		
	}

	/*public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return getComments();
	}

	

	public void setComments(List<Comment> cms) {
		// TODO Auto-generated method stub
		
	}*/

	/*public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return getComments();
	}*/

	/*public void setComments(List<Comment> cms) {
		// TODO Auto-generated method stub
		
	}*/

	/*public void setLiked(Boolean isLike) {
		// TODO Auto-generated method stub
		
	}*/

	/*public List<Post> getPostList() {
		// TODO Auto-generated method stub
		return getPostList();
	}**/


	

		/*public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}*/
		
		


}

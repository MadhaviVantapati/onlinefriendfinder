package com.onlinefriendfinder.entity;

	import java.time.LocalDate;
	import java.time.LocalDateTime;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
	import com.fasterxml.jackson.databind.annotation.JsonSerialize;
	import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
	import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

	@Entity
	@Table(name="comments")
	public class Comment {

		@Id
		@GeneratedValue
		private int coomentId;
		private String commentText;
		
		//@JsonDeserialize(using = LocalDateDeserializer.class)
		//@JsonSerialize(using = LocalDateSerializer.class)
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
		private LocalDate createdOn;
		
		@ManyToOne
		@JoinColumn(name = "user_id")//referencedColumnName = "userId")
		//@JsonManagedReference("commentedUser")
		private User user;
		
		@ManyToOne
		@JoinColumn(name = "post_id")//referencedColumnName = "postId")
		//@JsonManagedReference("userCommand")
		private Post post;


		public int getCoomentId() {
			return coomentId;
		}

		public void setCoomentId(int coomentId) {
			this.coomentId = coomentId;
		}

		public String getCommentText() {
			return commentText;
		}

		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}

		public LocalDate getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(LocalDate createdOn) {
			this.createdOn = createdOn;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}
		


}

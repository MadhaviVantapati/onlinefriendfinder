package com.onlinefriendfinder.entity;
import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "user_details")
public class User {

	@Id
	@GeneratedValue
	private int userId;
	private String firstName; 
	private String lastName;
	
	//@JsonDeserialize(using = LocalDateDeserializer.class)
	//@JsonSerialize(using = LocalDateSerializer.class)
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
	private LocalDate dob;
	
	private String email;
	private String mobile;
	private String school;
	private String college;
	private String username;
	private String password;
	private String status;
	@Column(name="isBlocked")
	private boolean isBlocked;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	
	/*@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Complaint> complaints;*/
	
	/*@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@JsonBackReference("commentedUser")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Likes> likes;*/
	
	/*@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference("userRef")
	private List<Post> posts;*/
	
	/*@OneToMany(mappedBy = "sender" , fetch = FetchType.EAGER)
	@JsonManagedReference("userReq")
	
	@Fetch(value = FetchMode.SUBSELECT)
	private List<FriendReq> senderFriendReqs;
	
	@OneToMany(mappedBy = "reciever" , fetch = FetchType.EAGER)
	@JsonManagedReference("receiverReq")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<FriendReq> recieverFriendReqs;

*/
//	public User() {
//		super();
//	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setComplaints(List<Complaint> cms) {
		// TODO Auto-generated method stub
		
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	/*public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}*/

	/*public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}*/

	/*public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}*/
	
	

}
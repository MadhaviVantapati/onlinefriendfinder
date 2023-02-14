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

	import com.fasterxml.jackson.annotation.JsonFormat;
	import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
	import com.fasterxml.jackson.databind.annotation.JsonSerialize;
	import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
	import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

	/*]
	 
	 {
		"complaintText" : "Inappropiate user",
		"registeredOn" : "2021-01-29",
		"status" : "Approved",
		"comments" : "User is absuive"
	}
	  
	 */

	@Entity
	@Table(name="complaints")
	public class Complaint {

		@Id
		@GeneratedValue
		private int complaintId;
		private String complaintText;
		
		//@JsonDeserialize(using = LocalDateDeserializer.class)
		//@JsonSerialize(using = LocalDateSerializer.class)
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
		private LocalDate registeredOn;
		
		private String status;
		private String comments;
		
		@ManyToOne
		@JoinColumn(name = "user_id")
		private User user;

		

		public int getComplaintId() {
			return complaintId;
		}

		public void setComplaintId(int complaintId) {
			this.complaintId = complaintId;
		}
		public String getComplaintText() {
			return complaintText;
		}

		public void setComplaintText(String complaintText) {
			this.complaintText = complaintText;
		}

		public LocalDate getRegisteredOn() {
			return registeredOn;
		}

		public void setRegisteredOn(LocalDate registeredOn) {
			this.registeredOn = registeredOn;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		/*public String getComments() {
			return comments;
		}

		public void setComments(Comment comment) {
			this.comments = comment;
		}*/

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
		

}

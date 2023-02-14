package com.onlinefriendfinder.entity;


	import java.time.LocalDate;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonFormat;
	import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
	import com.fasterxml.jackson.databind.annotation.JsonSerialize;
	import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
	import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

	@Entity
	public class Poll {
		
		@Id
		@GeneratedValue
		private int pollId;
		private String question;
		
		//@JsonDeserialize(using = LocalDateDeserializer.class)
		//@JsonSerialize(using = LocalDateSerializer.class)
		//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
		private LocalDate createdOn;

		/*public Poll() {
			super();
		}

		public Poll(int pollId, String question, LocalDate createdOn) {
			super();
			this.pollId = pollId;
			this.question = question;
			this.createdOn = createdOn;
		}*/

		public int getPollId() {
			return pollId;
		}

		public void setPollId(int pollId) {
			this.pollId = pollId;
		}

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public LocalDate getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(LocalDate createdOn) {
			this.createdOn = createdOn;
		}
		
		

}

package com.onlinefriendfinder.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatId;
	private boolean isSeen;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id",referencedColumnName="userId", insertable = false, updatable = false)
	private User sender;

	@ManyToOne(optional=false)
	@JoinColumn(name="user_id",referencedColumnName="userId", insertable = false, updatable = false)
	private User reciever;
	
	private String senderMessage;
	private String recieverMessage;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") //2021-01-29
	private LocalDate messageDate;

	public Chat() {
		super();
	}

	public Chat(int chatId, boolean isSeen, User sender, User reciever, String senderMessage, String recieverMessage,
			LocalDate messageDate) {
		super();
		this.chatId = chatId;
		this.isSeen = isSeen;
		this.sender = sender;
		this.reciever = reciever;
		this.senderMessage = senderMessage;
		this.recieverMessage = recieverMessage;
		this.messageDate = messageDate;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public boolean isSeen() {
		return isSeen;
	}

	public void setSeen(boolean isSeen) {
		this.isSeen = isSeen;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReciever() {
		return reciever;
	}

	public void setReciever(User reciever) {
		this.reciever = reciever;
	}

	public String getSenderMessage() {
		return senderMessage;
	}

	public void setSenderMessage(String senderMessage) {
		this.senderMessage = senderMessage;
	}

	public String getRecieverMessage() {
		return recieverMessage;
	}

	public void setRecieverMessage(String recieverMessage) {
		this.recieverMessage = recieverMessage;
	}

	public LocalDate getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(LocalDate messageDate) {
		this.messageDate = messageDate;
	}

	
	

}

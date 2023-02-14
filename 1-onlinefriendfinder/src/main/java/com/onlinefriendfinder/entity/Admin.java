package com.onlinefriendfinder.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long admin_id;
	private String username;
	private String email_id;
	private String password;
	private boolean isBlocked;
	
	public long getAdmin_id() {return admin_id;
	}
	public void setAdmin_id(long admin_id) {
		this.admin_id = admin_id;
		}
	public String getUsername() {
		return username;
		}
	public void setUsername(String username) {
		this.username = username;
		}
	public String getEmail_id() {
		return email_id;
		}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
		}
	public String getPassword() {
		return password;
		}
	public void setPassword(String password) {
		this.password = password;
		}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	}


package com.onlinefriendfinder.entity;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

	@Entity
	public class Address {

		@Id
		@GeneratedValue
		private int addressId;
		private String city;
		private String state;
		private String pincode;
		private String country;
		
		/*public Address() {
			super();
		}*/
		
	/*	public Address(int addressId, String city, String state, String pincode, String country) {
			super();
			this.addressId = addressId;
			this.city = city;
			this.state = state;
			this.pincode = pincode;
			this.country = country;
		}*/

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}
		
		

}

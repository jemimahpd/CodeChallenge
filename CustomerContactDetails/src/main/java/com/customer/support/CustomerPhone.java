package com.customer.support;

public class CustomerPhone {

	private String customerid;

	private String firstname;

	  private String lastname;
	  
	  private String phone;
		
		private String status;

		public CustomerPhone(String customerid, String firstname, String lastname, String phone, String status) {
			super();
			this.customerid = customerid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.phone = phone;
			this.status = status;
		}

		public String getCustomerid() {
			return customerid;
		}

		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		
		

		
		
	
}

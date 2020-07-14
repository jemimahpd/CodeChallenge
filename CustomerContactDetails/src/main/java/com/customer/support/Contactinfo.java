package com.customer.support;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

//This class represents the ContactInfo class in MySQL
@Entity
@Table(name = "Contactinfo")
public class Contactinfo {

	@Id
	private String contactid;
	
	private String custid;
	
	private String phone;
	
	private String status;
	
	/*
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name="custid") //@Fetch(FetchMode.JOIN) Customer customer;
	 */
	
	public String getContactid() {
		return contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
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

	/*
	 * public Customer getCustomer() { return customer; }
	 * 
	 * public void setCustomer(Customer customer) { this.customer = customer; }
	 */
	
	
}

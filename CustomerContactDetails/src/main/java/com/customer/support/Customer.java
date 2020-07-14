package com.customer.support;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This class represents customer table in MySQL
@Entity
@Table(name ="customer")
public class Customer {

	@Id
	private String customerid;

	private String firstname;

	  private String lastname;
	  
		/*
		 * @OneToMany(targetEntity = ContactInfo.class,cascade=CascadeType.ALL)
		 * 
		 * @JoinColumn(name="custid") private List<ContactInfo> contactlist;
		 */
	  
	  @OneToMany(targetEntity = Contactinfo.class,cascade = CascadeType.ALL)
	  @JoinColumn(name="custid")
      private List<Contactinfo> contactlist;
	  
	  
	  
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

	

	
}

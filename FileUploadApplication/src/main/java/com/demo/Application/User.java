package com.demo.Application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//This class is created for the User table in MySQL
@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  //@GeneratedValue(strategy=GenerationType.AUTO)
  private String userid;

private double coins;

  private String username;
  
  public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public double getCoins() {
		return coins;
	}

	public void setCoins(double coins) {
		this.coins = coins;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
  
}

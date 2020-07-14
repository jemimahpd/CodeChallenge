package com.customer.support;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//This interface is created to handle CRUD operations
public interface ContactInfoRepository extends CrudRepository<Contactinfo, String>{
	
	//This method sets the phone number of a customer to active status
	@Modifying
	@Transactional 
	@Query("update Contactinfo c set c.status='active' where c.custid =:custid and c.phone =:phone")
	public int activatePhoneNo (@Param("phone") String phone,@Param("custid") String custid);
}

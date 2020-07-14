package com.customer.support;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


//This interface is created to handle CRUD operations
public interface CustomerRepository extends CrudRepository<Customer, String>{

	//This method fetches customer's phone number with customer id
	@Query(value="select new com.customer.support.CustomerPhone(a.customerid,a.firstname,a.lastname,b.phone,b.status) from Customer a join a.contactlist b where a.customerid=:custid")
	public List<CustomerPhone> findCustomerPhoneNo(@Param("custid") String custid);
	
	//This method fetches all the customers phone number
	@Query(value="select new com.customer.support.CustomerPhone(a.customerid,a.firstname,a.lastname,b.phone,b.status) from Customer a join a.contactlist b")
	public List<CustomerPhone> findAllCustomerPhoneNos();
	
}
	
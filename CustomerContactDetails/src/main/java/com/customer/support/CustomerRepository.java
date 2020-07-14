package com.customer.support;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, String>{

	@Query(value="select new com.customer.support.CustomerPhone(a.customerid,a.firstname,a.lastname,b.phone,b.status) from Customer a join a.contactlist b where a.customerid=:custid")
	public List<CustomerPhone> findCustomerPhoneNo(@Param("custid") String custid);
	
	@Query(value="select new com.customer.support.CustomerPhone(a.customerid,a.firstname,a.lastname,b.phone,b.status) from Customer a join a.contactlist b")
	public List<CustomerPhone> findAllCustomerPhoneNos();
	
}
	
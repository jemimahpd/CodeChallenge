package com.demo.Application;

import org.springframework.data.repository.CrudRepository;

//This interface is created to handle CRUD operations
public interface UserRepository extends CrudRepository<User, String>{

}

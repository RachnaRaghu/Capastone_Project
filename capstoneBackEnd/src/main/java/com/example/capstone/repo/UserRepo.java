package com.example.capstone.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.capstone.entity.User;
@Repository
public interface UserRepo extends CrudRepository<User, String>{

	 @Query(value="select u from User u where u.userName = ?1 and u.password = ?2")
	public User findByEmailAndPassword(String userName, String password);

}

package com.fivepoints.fivesn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fivepoints.fivesn.entities.Role;
import com.fivepoints.fivesn.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u from User u  where u.role= :x ")
	public List<User> getUserByRole(@Param("x") Role role);

	@Query("Select u from User u  where u.name like %:x% ")
	public List<User> getUserByName(@Param("x") String name);

	@Query("Select u from User u  where u.blocked=true")
	public User userBolcked(@Param("x") String name);

}

package com.nainsree.demo.FlightService.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nainsree.demo.FlightService.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	public Optional<User> findByUserName(String userName);
	

}

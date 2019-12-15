package com.nainsree.demo.FlightService.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import com.nainsree.demo.FlightService.Entity.CustomUserDetails;
import com.nainsree.demo.FlightService.Entity.User;
import com.nainsree.demo.FlightService.Repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


	@Autowired
	UserRepository userRepo;
	public CustomUserDetailsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user=userRepo.findByUserName(username);
		System.out.println("MY User:: "+user.get());
		user.orElseThrow(()-> new UsernameNotFoundException("Unknown Username"));
		return new CustomUserDetails(user);
	}

}

package com.nainsree.demo.FlightService.Entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;

public class CustomUserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private String userName;
	private String userPwd;
	private boolean isEnabled;
	private List<SimpleGrantedAuthority> authority;

	public CustomUserDetails(Optional<User> user) {
		// TODO Auto-generated constructor stub
		User loggingUser = user.get();
		this.userName = loggingUser.getUserName();
		this.userPwd = loggingUser.getUserPwd();
		this.isEnabled = loggingUser.isActive();
		this.authority =Arrays.asList(loggingUser.getRoles().split(",")).stream()
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
		System.out.println("My user Athourity ::"+ authority );
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isEnabled;
	}

}

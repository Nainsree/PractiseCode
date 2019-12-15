package com.nainsree.demo.FlightService.CustomizedClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthenticationHandler extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("nainsree").password("nainsree").roles("User");
		auth.userDetailsService(userDetailsService);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	 @Override protected void configure(HttpSecurity http) throws Exception { 
		 http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
		 .antMatchers("/FindFlights/*").hasRole("ADMIN").antMatchers("/").permitAll().and().formLogin();
	 }
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { //
	 * logger. //
	 * debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity)."
	 * );
	 * 
	 * http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().
	 * formLogin().and().httpBasic().and().sessionManagement().sessionCreationPolicy
	 * (SessionCreationPolicy.STATELESS);
	 * //.csrf().disable().authorizeRequests().anyRequest().authenticated().and().
	 * httpBasic().and() }
	 */

}

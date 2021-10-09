package com.backend.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.service.entities.User;
import com.backend.service.repository.UserDetailsRepository;

@Service
public class CustomUserService implements UserDetailsService{

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDetailsRepository.findByUserName(username);
		if(null==user) {
			throw new UsernameNotFoundException("User. Not Found with username"+username);
		}
		return null;
	}
		
	
	
}

package com.backend.service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.backend.service.entities.Authority;
import com.backend.service.entities.User;
import com.backend.service.repository.UserDetailsRepository;



@SpringBootApplication
public class BackendServiceApplication {
	
	
	@Autowired
	private PasswordEncoder passwordEncode;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		List<Authority> authorityList=new ArrayList<>();
		
		authorityList.add(createAuthority("USER","User role"));
	//	authorityList.add(createAuthority("ADMIN", "Admin role"));
		
		User user=new User();
		
		user.setUserName("jamesestger");
		user.setFirstName("James");
		user.setLastName("CF");
		
		user.setPassword(passwordEncode.encode("123456"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		
		userDetailsRepository.save(user);
		
	}
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}

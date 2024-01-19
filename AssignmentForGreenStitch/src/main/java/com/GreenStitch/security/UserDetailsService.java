package com.GreenStitch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.GreenStitch.model.UserInfo;
import com.GreenStitch.repository.UserRepository;


@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserInfo user  = userRepo.findByEmail(email);
		
		if(user!=null)
		{
			return new UserDetails(user);
		}
		
		throw new UsernameNotFoundException("user not found with this email!!! : "+email);
	}
 
}

package org.studyeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.studyeasy.model.User;
import org.studyeasy.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = repo.findByUsername(username);
		System.out.println("hi");
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserImpl(user);
	}
	
	public void registerUser(User user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		
	}

}

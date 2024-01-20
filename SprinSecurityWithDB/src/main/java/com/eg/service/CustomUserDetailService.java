package com.eg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eg.model.CustomUserDetail;
import com.eg.model.User;
import com.eg.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Fetching user from database
		Optional<User> user = uRepo.findById(username);
		if (user.get() == null) {
			throw new UsernameNotFoundException("User not found !!!");
		}
		CustomUserDetail customUserDetails = new CustomUserDetail(user.get());
		return customUserDetails;
	}
}

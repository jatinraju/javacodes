package com.eg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.model.User;
import com.eg.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo urepo;

	public User addUser(User u) {
		User eu = urepo.findByUname(u.getUname());
		if (eu == null) {
			urepo.save(u);
			return u;
		}
		return null;

	}

}

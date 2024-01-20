package com.eg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eg.model.User;
import com.eg.repo.UserRepo;

@SpringBootApplication
public class SprinSecurityWithDbApplication implements CommandLineRunner {
	@Autowired
	private UserRepo urepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SprinSecurityWithDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
		user.setRole("ROLE_ADMIN");
		urepo.save(user);

		User user1 = new User();
		user1.setId("normal");
		user1.setPassword(this.bCryptPasswordEncoder.encode("normal"));
		user1.setRole("ROLE_NORMAL");
		urepo.save(user1);
	}

}

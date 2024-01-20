package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}

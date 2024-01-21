package com.eg.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Post;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

	public List<Post> findByUserId(int id);

}

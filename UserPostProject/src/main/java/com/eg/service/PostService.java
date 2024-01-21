package com.eg.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eg.model.Post;
import com.eg.repo.PostRepo;

@Service
public class PostService {

	@Autowired
	private PostRepo prepo;

	@Transactional
	public Post addPost(String desc, String filePath, int uid) {
		try {
			byte[] imageData = Files.readAllBytes(Paths.get(filePath));
			Post p = new Post();
			p.setImageData(imageData);
			p.setUserId(uid);
			p.setPostDesc(desc);
			prepo.save(p);
			return p;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Post> getPostByUserId(int id) {
		List<Post> plist = prepo.findByUserId(id);
		if (plist.isEmpty()) {
			return null;
		}
		return plist;
	}

}

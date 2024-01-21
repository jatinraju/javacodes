package com.eg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eg.model.Post;
import com.eg.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService pservice;

	@PostMapping("/add/{uid}")
	public ResponseEntity<?> addPost(@RequestParam("postDesc") String desc, @RequestParam("filePath") String filePath,
			@PathVariable("uid") int uid) {
		Post expected = pservice.addPost(desc, filePath, uid);
		if (expected == null) {
			return new ResponseEntity<>("No User Found!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Post Uploaded!", HttpStatus.OK);
	}

	@GetMapping("/get/{uid}")
	public ResponseEntity<?> getPostByUserid(@PathVariable("uid") int uid) {
		List<Post> plist = pservice.getPostByUserId(uid);
		if (plist == null) {
			return new ResponseEntity<>("No Post Found!", HttpStatus.OK);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		headers.add("PostDesc ", plist.get(0).getPostDesc());

		return new ResponseEntity<>(plist.get(0).getImageData(), headers, HttpStatus.OK);
	}

}

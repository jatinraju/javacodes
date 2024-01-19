package com.idb.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idb.entity.Image;
import com.idb.repo.ImageRepository;

@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Transactional
	public void saveImageFromFileSystem(String filePath) {
		try {
			byte[] imageData = Files.readAllBytes(Paths.get(filePath));
			Image image = new Image();
			image.setImageData(imageData);
			imageRepository.save(image);
		} catch (IOException e) {
			e.printStackTrace();
			// Handle exception (log it, throw a custom exception, etc.)
		}
	}

	public Image getImage(Long id) {
		return imageRepository.findById(id).orElse(null);
	}
}

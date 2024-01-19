package com.idb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idb.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
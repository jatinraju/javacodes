package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}

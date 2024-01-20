package com.eg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eg.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}

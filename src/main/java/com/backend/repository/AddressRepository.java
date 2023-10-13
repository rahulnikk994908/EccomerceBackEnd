package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}

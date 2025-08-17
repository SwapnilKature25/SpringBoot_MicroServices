package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>
{

	// Custom method to delete all addresses for a given empId
    void deleteByEmpId(Integer empId);
}

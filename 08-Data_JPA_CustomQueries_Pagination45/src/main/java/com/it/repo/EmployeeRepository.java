package com.it.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.it.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	@Query("from Employee")
	public List<Employee> getAllEmps();

	@Query("from Employee where eGen=:gender")   // positional parameter
	public List<Employee> getEmpsWithGender(String gender);
	
//	 nativeQuery as true means no conversion is required it is direct DB dependent query
	@Query(value="select * from employee", nativeQuery = true)  // if you are using SQL query then we need to specify by using nativeQUery as true
	public List<Employee> getEmpsSQL();

	// UPDATE - update country for given id
    @Modifying
    @Transactional
    @Query("update Employee e set e.eCountry = :country where e.eId = :id")
    int updateEmpCountry(Integer id, String country);
    
    // UPDATE - update salary for gender
    @Modifying
    @Transactional
    @Query("update Employee e set e.eSal = :salary where e.eGen = :gender")
    int updateSalaryByGender(String gender, Double salary);
    
    // DELETE - delete by country
    @Modifying
    @Transactional
    @Query("delete from Employee e where e.eCountry = :country")
    int deleteByCountry(String country);
    
    // DELETE - delete by gender
    @Modifying
    @Transactional
    @Query("delete from Employee e where e.eGen = :gender")
    int deleteByGender(String gender);
	
}
 
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myclass.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT u FROM Employee u WHERE u.email= :email ")
	Employee findByEmail(@Param("email") String email);
}

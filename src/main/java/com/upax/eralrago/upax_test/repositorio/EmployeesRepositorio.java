package com.upax.eralrago.upax_test.repositorio;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upax.eralrago.upax_test.modelo.Employees;

@Repository
public interface EmployeesRepositorio extends JpaRepository<Employees, Integer> {
	
	Page<Employees> findByGenderId(Integer genderId, Pageable pageable);
	
    Page<Employees> findByJobId(Integer jobId, Pageable pageable);
    
}

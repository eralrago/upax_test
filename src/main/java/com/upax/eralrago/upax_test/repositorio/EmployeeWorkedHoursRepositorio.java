package com.upax.eralrago.upax_test.repositorio;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upax.eralrago.upax_test.modelo.EmployeeWorkedHours;
import com.upax.eralrago.upax_test.modelo.Employees;

@Repository
public interface EmployeeWorkedHoursRepositorio extends JpaRepository<EmployeeWorkedHours, Integer> {
	
	// Page<EmployeeWorkedHours> findByEmployeeId(Integer employeeId, Pageable pageable);
	
}

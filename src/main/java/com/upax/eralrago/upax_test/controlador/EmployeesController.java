package com.upax.eralrago.upax_test.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.eralrago.upax_test.modelo.Employees;
import com.upax.eralrago.upax_test.modelo.Genders;
import com.upax.eralrago.upax_test.repositorio.EmployeesRepositorio;
import com.upax.eralrago.upax_test.repositorio.GendersRepositorio;
import com.upax.eralrago.upax_test.repositorio.JobsRepositorio;

@RestController
@RequestMapping("/api")
public class EmployeesController {
	
	private Employees employees;
	
	@Autowired
	public JobsRepositorio jobsRepositorio;
	
	@Autowired
	public GendersRepositorio gendersRepositorio;
	
	@Autowired
	private EmployeesRepositorio employeesRepositorio;
	
	@GetMapping("/employees")
	public List<Employees> getEmployees () {
		return this.employeesRepositorio.findAll();
	}

}

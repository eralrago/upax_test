package com.upax.eralrago.upax_test.controlador;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.eralrago.upax_test.modelo.Employees;
import com.upax.eralrago.upax_test.modelo.Genders;
import com.upax.eralrago.upax_test.modelo.Jobs;
import com.upax.eralrago.upax_test.repositorio.EmployeesRepositorio;
import com.upax.eralrago.upax_test.repositorio.GendersRepositorio;
import com.upax.eralrago.upax_test.repositorio.JobsRepositorio;

@RestController
@RequestMapping("/api")
public class EmployeesController {
	
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
	
	// Creando Usuario
	@PostMapping("create_employe/{gender_id}/{job_id}/{name}/{last_name}/{birthdate}")
	public Employees createEmploye(@PathVariable(value = "gender_id") Integer genderId, @PathVariable(value = "job_id") Integer jobId, @PathVariable(value = "name") String name, @PathVariable(value = "last_name") String lastName, @PathVariable(value = "birthdate") Date birthdate) {
		JsonObject json = new JsonObject();
		Employees newEmploye = new Employees();
		List<Employees> allEmployees = this.employeesRepositorio.findAll();
		List<Genders> allGenders = this.gendersRepositorio.findAll();
		List<Jobs> allJobs = this.jobsRepositorio.findAll();
		for (Employees employees : allEmployees) {
			if (!employees.getName().equals(name) && !employees.getLastName().equals(lastName)) {
				
			}
		}
		return null;
	}
	

}

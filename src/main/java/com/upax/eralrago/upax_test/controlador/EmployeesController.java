package com.upax.eralrago.upax_test.controlador;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;

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
	
	// Created Employe
	@PostMapping("/create_employe/{gender_id}/{job_id}/{name}/{last_name}/{birthdate}")
	public Employees createEmploye(@PathVariable(value = "gender_id") Long genderId, 
			                       @PathVariable(value = "job_id") Long jobId, 
			                       @PathVariable(value = "name") String name, 
			                       @PathVariable(value = "last_name") String lastName, 
			                       @PathVariable(value = "birthdate") Date birthdate) {
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(birthdate);
		String strDateEmploye = date.substring(0, 4);
		int yearBirthdateEmploye = Integer.parseInt(strDateEmploye);
		
		Predicate<Employees> p1 = s -> s.getName().equals(name);
		Predicate<Employees> p2 = s -> s.getLastName().equals(lastName);
		
		List<Employees> allEmployees = this.employeesRepositorio.findAll();
		List<Genders> allGenders = this.gendersRepositorio.findAll();
		List<Jobs> allJobs = this.jobsRepositorio.findAll();
		
		LocalDate ahora = LocalDate.now();
		
		boolean b1 = allEmployees.stream().anyMatch(p1);
		boolean b2 = allEmployees.stream().anyMatch(p2);
		if (b1 && b2) {
			System.out.println("Empleado Existe");
		} else {
			if ((ahora.getYear() - yearBirthdateEmploye) >= 18) {
				System.out.println("Empleado NO Existe");
				System.out.println("Empleado es mayor de edad");
			} else {
				System.out.println("Empleado NO Existe");
				System.out.println("Empleado no es mayor de edad");
			}
		}
		return null;
	}
	

}

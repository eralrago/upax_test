package com.upax.eralrago.upax_test.controlador;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/*@GetMapping("/employees")
	public List<Employees> getEmployeesByJobId (@RequestParam(value = "job_id") int jobId) {
		return this.employeesRepositorio.findAll();
	}*/
	
	// Created Employe
	@PostMapping("/create_employe")
	public JSONObject createEmploye(@RequestParam(value = "gender_id") int genderId, 
			@RequestParam(value = "job_id") int jobId, 
			@RequestParam(value = "name") String name, 
			@RequestParam(value = "last_name") String lastName, 
			@RequestParam(value = "birthdate") Date birthdate) {

		JSONObject jo = new JSONObject();
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(birthdate);
		String strDateEmploye = date.substring(0, 4);
		int yearBirthdateEmploye = Integer.parseInt(strDateEmploye);
		
		Predicate<Employees> p1 = s -> s.getName().equals(name);
		Predicate<Employees> p2 = s -> s.getLastName().equals(lastName);
		Predicate<Genders> p3 = s -> s.getId() == genderId;
		Predicate<Jobs> p4 = s -> s.getId() == jobId;
		
		List<Employees> allEmployees = this.employeesRepositorio.findAll();
		List<Genders> allGenders = this.gendersRepositorio.findAll();
		List<Jobs> allJobs = this.jobsRepositorio.findAll();
		
		LocalDate ahora = LocalDate.now();
		
		boolean b1 = allEmployees.stream().anyMatch(p1);
		boolean b2 = allEmployees.stream().anyMatch(p2);
		boolean b3 = allGenders.stream().anyMatch(p3);
		boolean b4 = allJobs.stream().anyMatch(p4);
		
		if (!b1 && !b2) {
			if ((ahora.getYear() - yearBirthdateEmploye) >= 18) {
				if (b3) {
					if (b4) {
						Employees newEmployes = new Employees();
						for (Genders genders : allGenders) {
							if (genders.getId() == genderId) {
								newEmployes.setGenders(genders);
							}
						}
						for (Jobs jobs : allJobs) {
							if (jobs.getId() == jobId) {
								newEmployes.setJobs(jobs);
							}
						}
						newEmployes.setName(name);
						newEmployes.setLastName(lastName);
						newEmployes.setBirthdate(birthdate);
						this.employeesRepositorio.save(newEmployes);
						int lastidE = newEmployes.getId();
						jo.put("id", lastidE);
						jo.put("success", true);
					} else {
						jo.put("id", "null");
						jo.put("success", false);
					}
				} else {
					jo.put("id", "null");
					jo.put("success", false);
				}
			} else {
				jo.put("id", "null");
				jo.put("success", false);
			}
		} else {
			jo.put("id", "null");
			jo.put("success", false);
		}
		return jo;
	}
	
	
}

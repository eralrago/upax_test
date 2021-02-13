package com.upax.eralrago.upax_test.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.eralrago.upax_test.modelo.Jobs;
import com.upax.eralrago.upax_test.repositorio.JobsRepositorio;

import java.util.HashMap;  
import java.util.Map;  

@RestController
@RequestMapping("/api")
public class JobsController {
	
	@Autowired
	public JobsRepositorio jobsRepositorio;
	
	@GetMapping("/jobs")
	public List<Jobs> getAllJobs () {

		Map obj=new HashMap();
		
		List<Jobs> jobs = new ArrayList<>();
		
		jobs = this.jobsRepositorio.findAll();
		
		for (Jobs jobs2 : jobs) {
			System.out.println(jobs2.getName());
		}
		
		
		return this.jobsRepositorio.findAll();
	}

}

package com.upax.eralrago.upax_test.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.eralrago.upax_test.modelo.Jobs;
import com.upax.eralrago.upax_test.repositorio.JobsRepositorio;

@RestController
@RequestMapping("/api")
public class JobsController {
	
	@Autowired
	public JobsRepositorio jobsRepositorio;
	
	@GetMapping("/jobs")
	public List<Jobs> getAllJobs () {			
		return this.jobsRepositorio.findAll();
	}

}

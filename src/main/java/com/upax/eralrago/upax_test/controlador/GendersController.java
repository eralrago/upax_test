package com.upax.eralrago.upax_test.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upax.eralrago.upax_test.modelo.Genders;
import com.upax.eralrago.upax_test.repositorio.GendersRepositorio;

@RestController
@RequestMapping("/api")
public class GendersController {
	
	@Autowired
	public GendersRepositorio gendersRepositorio;
	
	@GetMapping("/genders")
	public List<Genders> getAllGenders () {
		return this.gendersRepositorio.findAll();
	}

}

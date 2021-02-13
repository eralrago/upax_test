package com.upax.eralrago.upax_test.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genders")
public class Genders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "genders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employees> employee = new ArrayList<>();
	
	public Genders () {
		
	}

	public Genders(String name, List<Employees> employee) {
		super();
		this.name = name;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employees> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employees> employee) {
		this.employee = employee;
	}
}

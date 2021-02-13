package com.upax.eralrago.upax_test.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private Genders genders;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    @JsonIgnore
    private Jobs jobs;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birthdate")
	private Date birthdate;
	
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeWorkedHours> employeeWorkedHours = new ArrayList<>();

	public Employees() {
		
	}

	public Employees(Genders genders, Jobs jobs, String name, String lastName, Date birthdate,
			List<EmployeeWorkedHours> employeeWorkedHours) {
		super();
		this.genders = genders;
		this.jobs = jobs;
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.employeeWorkedHours = employeeWorkedHours;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Genders getGenders() {
		return genders;
	}

	public void setGenders(Genders genders) {
		this.genders = genders;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<EmployeeWorkedHours> getEmployeeWorkedHours() {
		return employeeWorkedHours;
	}

	public void setEmployeeWorkedHours(List<EmployeeWorkedHours> employeeWorkedHours) {
		this.employeeWorkedHours = employeeWorkedHours;
	}	
}

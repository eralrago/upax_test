package com.upax.eralrago.upax_test.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees_worked_hours")
public class EmployeeWorkedHours {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employees employees;
	
	@Column(name = "worked_hours")
	private Integer workedHours;
	
	@Column(name = "worked_date")
	private Date workedDate;

	public EmployeeWorkedHours() {
		
	}

	public EmployeeWorkedHours(Employees employees, Integer workedHours, Date workedDate) {
		super();
		this.employees = employees;
		this.workedHours = workedHours;
		this.workedDate = workedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Integer getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(Integer workedHours) {
		this.workedHours = workedHours;
	}

	public Date getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}
}

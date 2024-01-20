package com.eg.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	private List<Employee> employee;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int did, String dname, List<Employee> employee) {
		super();
		this.did = did;
		this.dname = dname;
		this.employee = employee;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", employee=" + employee + "]";
	}
}

package com.eg.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "a_id")
	private Address address;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int pid, String pname, Address address) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.address = address;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", address=" + address + "]";
	}
}

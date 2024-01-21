package com.eg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private int courseid;
	private String cname;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, int courseid, String cname) {
		super();
		this.cid = cid;
		this.courseid = courseid;
		this.cname = cname;

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", courseid=" + courseid + ", cname=" + cname + "]";
	}

}

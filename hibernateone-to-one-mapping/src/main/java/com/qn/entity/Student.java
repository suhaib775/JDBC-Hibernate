package com.qn.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student1")
public class Student {
	@Id//represent primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")//column table
	private int id;
	
	@Column(name="first_name")//column name in table
	private String firstName;
	

	@Column(name="last_name")//column name in table
	private String lasttName;
	

	@Column(name="email")//column name in table
	private String email;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_detail_id")
	private StudentDetail sd;
	
	public StudentDetail getSd() {
		return sd;
	}
	public void setSd(StudentDetail sd) {
		this.sd = sd;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", email=" + email + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLasttName() {
		return lasttName;
	}
	public String getEmail() {
		return email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Student() {
		super();
	}
	public Student(String firstName, String lasttName, String email) {
		super();
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}

}

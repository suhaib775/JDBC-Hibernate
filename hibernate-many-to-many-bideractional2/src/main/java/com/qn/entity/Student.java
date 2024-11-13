package com.qn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.Case;

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
	
	public int getId() {
		return id;
	}

	public List<Course> getC() {
		return c;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setC(List<Course> c) {
		this.c = c;
	}
	@OneToMany(mappedBy="s",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			                CascadeType.REFRESH})
	private List<Course> c;//There is a list of course for that we are using list
	
	public void addCourse(Course tempCourse) {
		if(c==null) {
			c=new ArrayList<Course>();
		}
		c.add(tempCourse);
		tempCourse.setS(this);
	}
	
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



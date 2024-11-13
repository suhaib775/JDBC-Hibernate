package com.qn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", s=" + s + "]";
	}

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="student_id")
	private Student s;
    
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinTable(name="course_instructor",
				joinColumns=@JoinColumn(name="course_id"),
	            inverseJoinColumns=@JoinColumn(name="instructor_id")) 
	
	private List<Instructor> i;
	
	public String getTitle() {
		return title;
	}

	public List<Instructor> getI() {
		return i;
	}

	public void setI(List<Instructor> i) {
		this.i = i;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public Course() {
		super();
	}

	public Course( String title) {
		super();

		this.title = title;
	}
}
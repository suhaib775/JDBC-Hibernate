package com.qn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_detail")
public class StudentDetail {
	  @Id
	  @GeneratedValue(strategy =GenerationType.IDENTITY)
	  
	  @Column(name="id")
      private int id;
	  
	  @Column(name="branch")
      private String branch;
	  
	  @Column(name="hobby")
      private String hobby;
      
      public StudentDetail() {
		super();
	}
	public StudentDetail(String branch, String hobby) {
		super();
		this.branch = branch;
		this.hobby = hobby;
	}
	public int getId() {
		return id;
	}
	public String getBranch() {
		return branch;
	}
	public String getHobby() {
		return hobby;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "StudentDetail [id=" + id + ", branch=" + branch + ", hobby=" + hobby + "]";
	}
}

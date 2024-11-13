package com.hib.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Course;
import com.qn.entity.Instructor;
import com.qn.entity.Student;
import com.qn.entity.StudentDetail;

public class App2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				addAnnotatedClass(StudentDetail.class).
				addAnnotatedClass(Course.class).
				addAnnotatedClass(Instructor.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor i = (Instructor)session.get(Instructor.class, 1);
		i.setEmail("msuhaib730@gmail.com");
		
		
		
		session.getTransaction().commit();

	}
}

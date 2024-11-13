package com.hib.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Course;
import com.qn.entity.Instructor;
import com.qn.entity.Student;
import com.qn.entity.StudentDetail;

public class App {
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
		
		Course c=session.get(Course.class,10);
		
		Instructor i1=new Instructor("Sachin","Tendulkar","sachin@gmail.com");
		Instructor i2=new Instructor("Rohith","Sharma","rohith@gmail.com");
		
		i1.addCourse(c);
		i2.addCourse(c);
		
		session.save(i1);
		session.save(i2);
		
		
		session.getTransaction().commit();

	}
}

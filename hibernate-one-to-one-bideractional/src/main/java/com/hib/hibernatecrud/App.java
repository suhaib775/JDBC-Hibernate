package com.hib.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Student;
import com.qn.entity.StudentDetail;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				addAnnotatedClass(StudentDetail.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		Student s = new Student("Hardik", "Pandya", "hardik@gmail.gom");
		StudentDetail sd = new StudentDetail("Fighter","Boxing");
		s.setSd(sd);
		sd.setS(s);
		session.save(s);
		session.getTransaction().commit();

	}
}

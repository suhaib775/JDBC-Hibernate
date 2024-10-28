package com.hib.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Student;

public class App2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
//		Student s = new Student("Rohit", "Sharma", "rohit@gmail.gom");
//		session.save(s);
//		Student s=(Student)session.get(Student.class, 1);
//		s.setLasttName("raju");
//		session.update(s);
		
//		Student s=(Student)session.get(Student.class, 1);
//		session.delete(s);

		
		
		session.getTransaction().commit();

	}
}

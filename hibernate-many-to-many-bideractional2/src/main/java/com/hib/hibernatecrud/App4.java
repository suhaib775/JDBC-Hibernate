package com.hib.hibernatecrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Student;
import com.qn.entity.StudentDetail;

public class App4 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
							configure("hibernate.cfg.xml").
							addAnnotatedClass(Student.class).
							addAnnotatedClass(StudentDetail.class).
							buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student s = (Student)session.get(Student.class, 2);
		
		
		session.delete(s);
		
		session.getTransaction().commit();
	}
}
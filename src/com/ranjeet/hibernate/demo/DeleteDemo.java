package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Deleting a new Instructor object ...");
			
			int id = 5;
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			
			if(instructor!=null) {
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}

}

package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new Instructor object ...");
			
			Instructor instructor = new Instructor("Hello11","World","1234511@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail(
												"helloworld1.com",
												"codingbanda1111!!!");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}

}

package com.ranjeet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Course;
import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Deleting Course object ...");
			
			session.beginTransaction();
			
			int id = 10;
			
			Course course = session.get(Course.class, id);
			
			System.out.println(course);
			
			session.delete(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

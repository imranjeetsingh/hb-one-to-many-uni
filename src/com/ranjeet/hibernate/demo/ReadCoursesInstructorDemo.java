package com.ranjeet.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Course;
import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;

public class ReadCoursesInstructorDemo {

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
			System.out.println("Reading a new Course object ...");
			
			session.beginTransaction();
			
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println(instructor);
			
			List<Course> courses = instructor.getCourses();
			
			System.out.println(instructor.getCourses());
			
//			for(Course cousre : courses)
//				sys
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

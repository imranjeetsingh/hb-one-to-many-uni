package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Course;
import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;
import com.ranjeet.hibernate.entity.Review;

public class ReadCoursesReviewDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new review object ...");
			
			session.beginTransaction();
			
			int id =10;
			Course tempCourse = session.get(Course.class, id);
			
			System.out.println(tempCourse);
			
			System.out.println(tempCourse.getReviews());
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

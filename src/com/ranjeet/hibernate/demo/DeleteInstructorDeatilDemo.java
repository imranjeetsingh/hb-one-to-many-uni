package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Instructor;
import com.ranjeet.hibernate.entity.InstructorDetail;

public class DeleteInstructorDeatilDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Retrieving Instructor object ...");
			int id=2;
			session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			instructorDetail.getInstructor().setInstructorDetail(null);
			System.out.println("Deleting Instructor object ...");
			session.delete(instructorDetail);
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}

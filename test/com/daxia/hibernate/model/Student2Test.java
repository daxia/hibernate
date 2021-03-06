package com.daxia.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Student2Test {
	
	private static SessionFactory sf;
	@BeforeClass
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testStudentSave(){
		Student2PK pk = new Student2PK();
		pk.setId(1);  
		pk.setName("wang");
		
		Student2 student = new Student2();
		student.setPk(pk);
		student.setAge(1);
		
		//操作hibernate
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}

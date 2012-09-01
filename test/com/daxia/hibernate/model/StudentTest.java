package com.daxia.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass(){
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	//测试session的save方法
	@Test
	public void testSave(){
		Student stu = new Student();
		stu.setAge(55);
		stu.setName("zhang");
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
	}
	
	//测试session的update
	@Test
	public void testUpdate(){
		
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}

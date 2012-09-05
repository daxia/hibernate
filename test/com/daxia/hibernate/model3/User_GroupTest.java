package com.daxia.hibernate.model3;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class User_GroupTest {
	private static SessionFactory sf ;
	@BeforeClass
	public static void beforeClass(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
	@Test
	public void testsaveUser(){
		User user = new User();
		Group group = new Group();
		
		user.setName("hu");
		group.setName("2007");
		
		group.getUsers().add(user);
		user.setGroup(group);
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(group);
		s.getTransaction().commit();
	}
	
	@Test
	public void testGetUser(){
		
		testsaveUser();
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//User u = (User) s.get(User.class, 1);
		Group g = (Group) s.get(Group.class, 1);
		System.out.println(g.getClass().getName());
		
		s.getTransaction().commit();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}

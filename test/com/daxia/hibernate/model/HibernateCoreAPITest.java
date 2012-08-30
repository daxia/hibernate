package com.daxia.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateCoreAPITest {
	private static SessionFactory sf;  //代表与数据库的链接
	@BeforeClass
	public static void beforeClass(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@Test
	public void testTeacherSave(){
		TeacherPK pk = new TeacherPK();
		pk.setName("zhong");
		
		Teacher t = new Teacher();
		t.setPk(pk);
		t.setBirthDate(new Date());
		t.setTitle("middle");
		t.setZhiCheng(ZhiCheng.B);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.close();
	
	}
	
	@Test
	public void test3State(){
		TeacherPK pk = new TeacherPK();
		pk.setName("zhong");
		
		Teacher t = new Teacher();
		t.setPk(pk);
		t.setBirthDate(new Date());
		t.setTitle("middle");
		t.setZhiCheng(ZhiCheng.B);
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		System.out.println(pk.getId());
		session.getTransaction().commit();
		
	}
	
	@Test
	public void testLoad(){
		TeacherPK pk = new TeacherPK();
		pk.setId(0);
		pk.setName("zhong");
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher teacher = (Teacher) session.load(Teacher.class, pk);
		System.out.println(teacher.getPk().getName());
		session.getTransaction().commit();
	}
	
	@Test
	public void testGet(){
		TeacherPK pk = new TeacherPK();
		pk.setId(0);
		pk.setName("zhong");
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, pk);
		System.out.println(teacher.getPk().getName());
		session.getTransaction().commit();
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}

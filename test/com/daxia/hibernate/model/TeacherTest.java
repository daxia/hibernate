package com.daxia.hibernate.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TeacherTest {
	private static SessionFactory sf = null;
	
	@BeforeClass  //准备工作//先初始化，单例
	public static void beforeClass(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@Test
	public void testTeacherSave() throws Exception {
		TeacherPK pk = new TeacherPK();
		//teacher.setId(7);
		pk.setName("wang");
		
		Teacher teacher = new Teacher();
		teacher.setPk(pk);
		teacher.setTitle("math");
		teacher.setBirthDate(new Date());
		teacher.setZhiCheng(ZhiCheng.A);
		
		//操作hibernate
		//getCurrentSession：如果有Session，直接拿，如果没有，则创建一个
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}

package com.daxia.hibernate.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static SessionFactory sf ;
	
	@BeforeClass
	public static void beforeClass(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		//new SchemaExport(new Configuration().configure()).create(false, true);
	}
	
	
	@Test
	public void testSave(){
		Student stu = new Student();
		stu.setName("hujing");
		
		Course c = new Course();
		c.setName("math");
		
		Score score = new Score();
		score.setCourse(c);
		score.setStudent(stu);
		
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//注意save顺序
		s.save(stu);
		s.save(c);
		s.save(score);
		s.getTransaction().commit();
	}
	
	@Test
	public void testLoad(){
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu = (Student) s.load(Student.class, 2);
		//获取学生的课程
		for(Course c: stu.getCourses()){
			System.out.println(c.getName());
		}
		s.getTransaction().commit();
	}
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}

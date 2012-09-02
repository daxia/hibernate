package com.daxia.hibernate.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	// test.session.save()
	@Test
	public void testSave() {
		Student stu = new Student();
		stu.setAge(22);
		stu.setName("hujing");

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();
	}

	// test session.delete()
	@Test
	public void testDelete() {
		Student stu = new Student();
		stu.setName("hujing");
		stu.setAge(22);
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.save(stu);
		s.getTransaction().commit();

		// 删除数据
		Session s2 = sf.getCurrentSession();
		s2.beginTransaction();
		s2.delete(stu);
		s2.getTransaction().commit();
	}

	// test session.get()
	@Test
	public void testGet() {

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu2 = (Student) s.get(Student.class, 4);
		System.out.println(stu2.getName());
		s.getTransaction().commit();
	}

	// test session.load()
	@Test
	public void testLoad() {

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		// 代理 Proxy load() 第二个参数：id
		Student stu2 = (Student) s.load(Student.class, 4);
		System.out.println(stu2.getName());
		s.getTransaction().commit();
	}

	// test session.update() 先获取表数据，然后更新需要更新的表数据字段
	@Test
	public void testUpdate() {

		// 获取表数据
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu2 = (Student) s.get(Student.class, 1);
		s.getTransaction().commit();

		// 更新表字段
		stu2.setName("zhang");

		// update
		Session s2 = sf.getCurrentSession();
		s2.beginTransaction();
		s2.update(stu2);
		s2.getTransaction().commit();
	}

	// update 至少需要知道id
	@Test
	public void testUpdate2() {
		Student stu = new Student();
		stu.setId(1);

		stu.setName("wang");
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.update(stu);
		s.getTransaction().commit();

	}

	// 只更新部分字段
	@Test
	public void testUpdate4() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		// HQL:Student是对象，非表
		Query q = s
				.createQuery("update Student s set s.name='hu' where s.id=1");
		q.executeUpdate();
		s.getTransaction().commit();
	}

	// saveOrUpdate()
	@Test
	public void testSaveOrUpdate() {
		Student stu = new Student();
		stu.setName("hujing");
		stu.setAge(22);

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		s.saveOrUpdate(stu); // 执行save
		s.getTransaction().commit();

		stu.setAge(23);

		Session s2 = sf.getCurrentSession();
		s2.beginTransaction();
		s2.saveOrUpdate(stu);// 执行update
		s2.getTransaction().commit();
	}

	//clear()
	@Test
	public void testClear() {
		// 获取表数据
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Student stu1 = (Student) s.get(Student.class, 1);
		System.out.println(stu1.getClass());
		
		//清除，直接清除内存中的缓存数据
		s.clear();//如果没有clear，则只会查询数据库一次，第二次会从缓存中查找
		
		Student stu2 = (Student) s.get(Student.class, 1);
		System.out.println(stu2.getClass());
		s.getTransaction().commit();
	}

	//flush()
	@Test
	public void testFlush(){
		// 获取表数据
				Session s = sf.getCurrentSession();
				s.beginTransaction();
				Student stu1 = (Student) s.get(Student.class, 1);
				System.out.println(stu1.getClass());
				stu1.setAge(25);
				
				//强制将缓存中的内容和数据库中的内容做同步
				s.flush();
				
				stu1.setAge(55);
				s.getTransaction().commit();
	}
	
	//schemaExport建表
	@Test
	public void testSchemaExport(){
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
}

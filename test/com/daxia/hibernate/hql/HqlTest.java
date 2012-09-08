package com.daxia.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * test hql
 */
public class HqlTest {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforClass() {
		// new SchemaExport(new Configuration().configure()).create(false,
		// true);

		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testCreateTable() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}

	@Test
	public void testHQL_01() {

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q = (Query) s.createQuery("from Category"); //面向对象查询
		List<Category> categories = (List<Category>) q.list();
		for(Category c : categories){
			System.out.println(c.getName());
		}
		// s.save(o);
		s.getTransaction().commit();

	}

	@Test
	public void testHQL_02() {

		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Query q = (Query) s.createQuery("from Category c where c.name > 'c5'");
		List<Category> categories = (List<Category>) q.list();
		for(Category c : categories){
			System.out.println(c.getName());
		}
		s.getTransaction().commit();

	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}
}

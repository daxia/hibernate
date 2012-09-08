package com.daxia.hibernate.n_plus_1;

import java.util.Date;
import java.util.List;

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
public class N_plus_1Test {
	private static SessionFactory sf;

	@BeforeClass
	public static void beforClass() {
		// new SchemaExport(new Configuration().configure()).create(false,true);

		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testCreateTable() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}

	// save
	@Test
	public void testSave() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();

		for (int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setName("c" + 1);
			Topic t = new Topic();
			t.setCategory(c);
			t.setTitle("t" + i);
			t.setCreateDate(new Date());
			s.save(c);
			s.save(t);
		}
		s.getTransaction().commit();
	}

	@Test
	public void testQuery1() {
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		//List<Topic> topics = (List<Topic>) s.createCriteria(Topic.class).list();
		List<Topic> topics = (List<Topic>) s.createQuery("from Topic").list();
		for (Topic t : topics) {
			System.out.println(t.getId() + "-" + t.getTitle());
		}

		s.getTransaction().commit();
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}
}

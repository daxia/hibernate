package com.daxia.hibernate.tree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeTest {

	private static SessionFactory sf ;
	@BeforeClass
	public static void beforClass(){
		new SchemaExport(new Configuration().configure()).create(false, true);
		
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@Test
	public void testCreateTable(){
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
	
	@Test
	public void testSave(){
		Org o = new Org();
		o.setName("company");
		Org o1 = new Org();
		o1.setName("company1");
		Org o2 = new Org();
		o2.setName("company2");
		Org o11 = new Org();
		o11.setName("company1:part 1");
		Org o12 = new Org();
		o12.setName("company1:part 2");
		
		//建立关联映射
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o11.setParent(o1);
		o12.setParent(o1);
		o1.setParent(o);
		o2.setParent(o);
		
		Session s =  sf.getCurrentSession();
		s.beginTransaction();
		s.save(o);
		s.getTransaction().commit();
		
	}
	
	@Test
	public void testLoad(){
		testSave();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Org o= (Org) s.load(Org.class, 1);
		
		print(o,0);
		
		s.getTransaction().commit();
	}
	
	//使用递归
	private void print(Org o, int level) {
		String preStr = "";
		for(int i=0; i<level; i++){
			preStr += "----";
		}
		System.out.println(preStr + o.getName());
		for(Org child: o.getChildren()){
			print(child, level + 1);
		}
	}

	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}

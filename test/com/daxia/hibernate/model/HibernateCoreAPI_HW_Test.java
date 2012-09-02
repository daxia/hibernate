package com.daxia.hibernate.model;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import org.junit.Test;

/*
 * test Husband---Wife Mapping
 */
public class HibernateCoreAPI_HW_Test {

	/*
	 * private static SessionFactory sf;
	 * 
	 * @BeforeClass public static void beforeClass(){ sf = new
	 * AnnotationConfiguration().configure().buildSessionFactory(); }
	 */

	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}

	/*
	 * @AfterClass public static void afterClass(){ sf.close(); }
	 */
}

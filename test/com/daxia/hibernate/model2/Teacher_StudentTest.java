package com.daxia.hibernate.model2;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class Teacher_StudentTest {
	@Test
	public void testSchemaExport(){
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
}

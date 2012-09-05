package com.daxia.hibernate.model2;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
/*
 * 组件映射：Language是Developer的组件
 */
public class Developer_LanguageTest {
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
}

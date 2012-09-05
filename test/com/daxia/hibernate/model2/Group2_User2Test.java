package com.daxia.hibernate.model2;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
/*
 * group2->user2:一对多
 */
public class Group2_User2Test {
	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
	}
}

package simulation.session;

import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import simulation.TeacherEntity;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

//模仿Hibernate中的Session的原理
public class Session {
	String tableName = "teacher";
	Map<String, String> cfsMap = new HashMap<String, String>();

	String[] methodNames;

	public Session() {
		cfsMap.put("id", "id");
		cfsMap.put("name", "name");
		cfsMap.put("title", "title");

		methodNames = new String[cfsMap.size()];
		// Method[] method = new Method[cfsMap.size()];
	}

	public void save(TeacherEntity te) throws Exception {
		String sql = createSQL();
		executeSql(te, sql);
	}

	private void executeSql(TeacherEntity te, String sql) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hibernate", "root", "root");
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		
		for (int i = 0; i < methodNames.length; i++) {
			Method method = te.getClass().getMethod(methodNames[i]);
			
			Class c = method.getReturnType();
			if(c.getName().equals("java.lang.String")){
				//java 反射
				String returnValue = (String) method.invoke(te);
				//System.out.println(returnValue);
				ps.setString(i+1, returnValue);
			}
			if(c.getName().equals("int")){
				//java 反射
				Integer returnValue = (Integer) method.invoke(te);
				//System.out.println(returnValue);
				ps.setInt(i+1, returnValue);
			}
			//System.out.println(method.getName() + " | " + c.getName());
		}
		 ps.executeUpdate();
		 ps.close();
		 conn.close();
	}

	private String createSQL() {
		String str1 = "";
		int index = 0;
		for (String str : cfsMap.keySet()) {
			String v = cfsMap.get(str);
			v = Character.toUpperCase(v.charAt(0)) + v.substring(1);
			methodNames[index] = "get" + v;
			str1 += str + ",";
			index++;
		}
		str1 = str1.substring(0, str1.length() - 1);

		String str2 = "";
		for (int i = 0; i < cfsMap.size(); i++) {
			str2 += "?,";
		}
		str2 = str2.substring(0, str2.length() - 1);

		// System.out.println(str2);
		// System.out.println(str1);

		String sqlString = "insert into " + tableName + "(" + str1
				+ ")  values(" + str2 + ")";
		//System.out.println(sqlString);
		return sqlString;
	}

}

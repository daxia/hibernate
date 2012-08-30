import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.daxia.hibernate.model.Teacher;


public class TeacherTest {
	public static void main(String[] args){
		Teacher teacher = new Teacher();
		//teacher.setId(6);
		//teacher.setName("wang");
		teacher.setTitle("math");
		
		//操作hibernate
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory(); //cfg.configure()将hibernate.cfg.xml解析
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}

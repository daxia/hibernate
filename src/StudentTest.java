import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.daxia.hibernate.model.Student;


public class StudentTest {
	public static void main(String[] args){
		Student student = new Student();
		//student.setId(1);
		//student.setName("wang");
		//student.setAge(1);
		
		//操作hibernate
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory(); //cfg.configure()将hibernate.cfg.xml解析
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}

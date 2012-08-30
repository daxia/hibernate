package simulation;

import simulation.session.Session;



public class TeacherImpl {
	public static void main(String[] args) throws Exception{
		TeacherEntity te = new TeacherEntity();
		
		te.setId(26);
		te.setName("sheng");
		te.setTitle("middle");
		
		Session session = new Session();
		session.save(te);
	}
}

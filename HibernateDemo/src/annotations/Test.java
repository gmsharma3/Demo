package annotations;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {

	private SessionFactory factory;
	
	public static void main(String[] args) {
		Test test = new Test();
		test.start();
	}
	
	public void start() {
		try {
			factory = new AnnotationConfiguration().configure("annotation.hbm.xml").buildSessionFactory();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(getEmployeeById(1));
		System.out.println(getEmployeByName("sharma"));
		update();
	}
	
	public Employee getEmployeeById(int id) {
		Session session = factory.openSession();
		Employee emp = null;
		try {
			emp = (Employee) session.get(Employee.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Employee> getEmployeByName(String name){
		List<Employee> emp = null;
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("from Employee");
			query.setMaxResults(2);
			query.setFirstResult(1);
			emp = query.list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public void update(){
		String hql = "UPDATE Employee set salary = 10000 where id = 1";
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		int res = query.executeUpdate();
		System.out.println(res);
	}

}

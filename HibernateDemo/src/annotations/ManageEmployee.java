package annotations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	private SessionFactory factory;
	
	public static void main(String[] args) {
		ManageEmployee obj = new ManageEmployee();
		obj.start();
	}
	
	public void start() {
		try {
			factory = new Configuration().configure("annotation.hbm.xml").buildSessionFactory();
		} catch(Exception e){
			e.printStackTrace();
		}
		Employee employee1 = new Employee();
		employee1.setFirstName("test4");
		employee1.setLastName("test");
		employee1.setSalary(50000);
		
		Integer id = addEmployee(employee1);
		System.out.println(id);
		
		/*Employee employee2 = new Employee();
		employee2.setFirstName("test2");
		employee2.setLastName("G");
		employee2.setSalary(20000);
		
		id = addEmployee(employee2);
		System.out.println(id);
		
		Employee employee3 = new Employee();
		employee3.setFirstName("test1");
		employee3.setLastName("G");
		employee3.setSalary(30000);
		
		id = addEmployee(employee3);
		System.out.println(id);*/
		
		/*List<Employee> listOfEmployees = new ArrayList<Employee>();
		for(int i = 10000; i <= 100000; i++){
			Employee employee = new Employee();
			employee.setFirstName("first Name " + i);
			employee.setLastName("last Name " + i);
			employee.setSalary(10000 + i);
			listOfEmployees.add(employee);
		}
		addEmployees(listOfEmployees);*/
		
		long s = System.currentTimeMillis();
		List<Employee> employees = listEmployees();
		System.out.println(System.currentTimeMillis() - s);
		long s1 = System.currentTimeMillis();
		List<Employee> emp1 = listEmployees();
		System.out.println(System.currentTimeMillis() - s1);
		for(Employee emp : employees){
			//System.out.println(emp);
		}
		System.out.println(emp1.size());
		/*employee1.setSalary(30000);
		updateEmployee(employee1);
		System.out.println("After Updating");
		employees = listEmployees();
		for(Employee emp : employees){
			System.out.println(emp);
		}*/
	}
	
	private void addEmployees(List<Employee> listOfEmployees) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for(Employee employee : listOfEmployees){
				session.save(employee);
			}
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
			if(session != null) {
				session.close();
			}
		}
	}

	private void updateEmployee(Employee employee1) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(employee1);
			transaction.commit();
		} catch(Exception e){
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}

	private List<Employee> listEmployees() {
		List<Employee> employees = null;
		Session session = factory.openSession();
		employees = session.createQuery("FROM Employee").list();
		return employees;
	}

	public Integer addEmployee(Employee emp) {
		Session session = factory.openSession(new MyInterceptor() );
		Transaction transaction = null;
		Integer id = null;
		try {
			transaction = session.beginTransaction();
			id = (Integer) session.save(emp);
			transaction.commit();
		} catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return id;
	}

}

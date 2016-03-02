package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Certificate;
import model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	private SessionFactory factory;

	public static void main(String[] args) {
		Client client = new Client();
		client.process();
	}

	@SuppressWarnings("unchecked")
	public void process() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		@SuppressWarnings("rawtypes")
		/*List<Certificate> set1 = new ArrayList<Certificate>();
		set1.add(new Certificate("MCA"));
		set1.add(new Certificate("MBA"));
		set1.add(new Certificate("PMP"));
		int id1 = addEmployee("test1", "test2", 10000, set1);
		System.out.println(id1);*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ComputerScience", new Certificate("MCA"));
	    map.put("BusinessManagement", new Certificate("MBA"));
	    map.put("ProjectManagement", new Certificate("PMP"));
	    int id1 = addEmployee("test1", "test2", 10000, map);
	    System.out.println(id1);

		/*TreeSet set2 = new TreeSet();
		set2.add(new Certificate("BCA"));
		set2.add(new Certificate("BA"));*/

		// int id2 = addEmployee("test3", "test4", 2000, set2);
		// System.out.println(id2);
		List<Employee> employees = listEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		//deleteEmployee(2);
		updateEmployee(1, 100000);
		employees = listEmployees();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}

	public int addEmployee(String firstName, String lastName, int salary,
			Map<String, Object> set) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Integer id = null;
		try {
			/*transaction = session.beginTransaction();
			Employee employee = new Employee(firstName, lastName, salary);
			employee.setCertificates(set);
			id = (Integer) session.save(employee);
			transaction.commit();*/
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return id;
	}

	public List<Employee> listEmployees() {
		Session session = factory.openSession();
		Transaction transaction = null;
		List<Employee> employees = null;
		try {
			transaction = session.beginTransaction();
			employees = session.createQuery("from Employee").list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
		return employees;
	}

	public void updateEmployee(Integer id, int salary) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, id);
			emp.setSalary(salary);
			session.update(emp);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
	}
	
	public void deleteEmployee(int id) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, id);
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		}
	}

}

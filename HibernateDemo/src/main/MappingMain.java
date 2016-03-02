package main;

import java.util.List;

import model.Address;
import model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingMain {

	private SessionFactory factory;
	
	public static void main(String[] args) {
		MappingMain main = new MappingMain();
		main.process();
	}
	
	public void process() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e){
			e.printStackTrace();
		}
		Address address1 = new Address("street1", "city1", "state1", "zipcode1");
		Integer id1 = addEmployee("firstName", "lastName", 1000, address1);
		System.out.println(id1);
		//Address address2 = addAddress("street2", "city2", "state2", "zipcode2");
		//Integer id2 = addEmployee("test1", "test2", 2000, address2);
		//System.out.println(id2);
		
		List<Employee> employees = listEmployees();
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}
	
	public Address addAddress(String street, String city, String state, String zipcode) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Integer addressID = null;
	    Address address = null;
	    try {
	    	transaction = session.beginTransaction();
	    	address = new Address(street, city, state, zipcode);
	    	addressID = (Integer) session.save(address);
			transaction.commit();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	transaction.rollback();
	    }
	    return address;
	}
	
	public Integer addEmployee(String firstName, String lastName, int salary, Address address) {
		Session session = factory.openSession();
		Transaction transaction = null;
		Integer id = null;
		try {
			Employee employee = new Employee(firstName, lastName, salary, address);
			transaction = session.beginTransaction();
			id = (Integer) session.save(employee);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return id;
	}
	
	private List<Employee> listEmployees() {
		List<Employee> employees = null;
		Session session = factory.openSession();
		try {
			employees = session.createQuery("from Employee").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}


}

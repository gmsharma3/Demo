package model;

import java.util.Map;

public class Employee {

	private int id;

	private String firstName;

	private String lastName;

	private int salary;

	private Address address;

	public Employee() {

	}

	public Employee(String firstName, String lastName, int salary, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + "]";
	}

}

package com.example;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudySet {
	// hash: message integrity
	public static void main(String[] args) {
		// Set i) Unique ii) Un-ordered -> Cannot sort?
		Set<Integer> numbers = new TreeSet<>();
		numbers.add(4);
		numbers.add(Integer.valueOf(8));
		numbers.add(4);
		numbers.add(42);
		numbers.add(23);
		numbers.add(4);
		numbers.add(15);
		numbers.add(4);
		numbers.add(16);
		System.out.println(numbers);
		System.out.println(numbers.contains(108));
		Set<Employee> employees = new HashSet<>();
		employees.add(new Employee("1", "jack", "TR1", 100_000));
		employees.add(new Employee("2", "kate", "TR2", 200_000));
		employees.add(new Employee("3", "james", "TR3", 300_000));
		employees.add(new Employee("4", "ben", "TR4", 400_000));
		System.out.println(employees.contains(new Employee("3", "james", "TR3", 300_000)));
	}

}

class Employee {
	private String identity;
	private String fullname;
	private String iban;
	private double salary;

	public Employee(String identity, String fullname, String iban, double salary) {
		this.identity = identity;
		this.fullname = fullname;
		this.iban = iban;
		this.salary = salary;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return identity.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return this.identity.equals(other.identity);
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", iban=" + iban + ", salary=" + salary
				+ "]";
	}

}

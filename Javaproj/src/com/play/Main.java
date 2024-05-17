package com.play;

import java.util.*;

class Employee {
	
	private int id;
	private String name;
	private String dept;
	private double salary;

	public Employee(int id, String name, String dept, double salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Dept: " + dept + ", Salary: " + salary;
	}
}

public class Main {
	
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1, "John", "IT", 50000));
		employees.add(new Employee(2, "Jane", "HR", 60000));
		employees.add(new Employee(3, "Bob", "Finance", 55000));
		employees.add(new Employee(4, "Alice", "IT", 52000));

		Optional<Employee> secondHighestSalary = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();

		if (secondHighestSalary.isPresent()) {
			System.out.println("Second highest salary employee: " + secondHighestSalary.get());
		} else {
			System.out.println("No second highest salary found.");
		}
	}
}

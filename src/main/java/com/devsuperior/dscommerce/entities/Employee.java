package com.devsuperior.dscommerce.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Employee {
	
	public String name;
	public double grossSalary;
	public Employee(String name, double grossSalary) {
		this.name = name;
		this.grossSalary = grossSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	


}

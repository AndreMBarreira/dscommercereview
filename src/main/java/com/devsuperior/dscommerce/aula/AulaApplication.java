package com.devsuperior.dscommerce.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.dscommerce.entities.Employee;
import com.devsuperior.services.SalaryService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class AulaApplication implements CommandLineRunner {
	
	@Autowired
	private SalaryService salaryService;
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("Maria", 4000.00);
		System.out.println(salaryService.netSalary(employee));
		
	}
	public SalaryService getSalaryService() {
		return salaryService;
	}
	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	

}

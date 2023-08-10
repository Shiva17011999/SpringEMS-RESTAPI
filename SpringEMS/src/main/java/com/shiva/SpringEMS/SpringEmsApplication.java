package com.shiva.SpringEMS;

import com.shiva.SpringEMS.Model.Employee;
import com.shiva.SpringEMS.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmsApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Shiva");
		employee.setLastName("Allam");
		employee.setEmailId("shivaallam@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Akhil");
		employee1.setLastName("Pulluri");
		employee1.setEmailId("AkhilPulluri@gmail.com");
		employeeRepository.save(employee1);
	}
}

package com.github.itsAkshayDubey.aopwithspringpart1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.github.itsAkshayDubey.aopwithspringpart1.model.Employee;

@SpringBootApplication
public class AopWithSpringPart1Application implements CommandLineRunner{

	private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees/{id}";
	private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8081/api/v1/employees";

	public static void main(String[] args) {
		SpringApplication.run(AopWithSpringPart1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee e1 = new Employee(1, "ABC", "PQR", "abc.pqr@gmail.com");
		Employee e2 = new Employee(2, "DEF", "STU", "def.stu@gmail.com");
		Employee e3 = new Employee(3, "GHI", "VWX", "ghi.vwx@gmail.com");
		Employee e4 = new Employee(4, "JKL", "YZA", "jkll.yza@gmail.com");
		Employee e5 = new Employee(5, "MNO", "BCD", "mno.bcd@gmail.com");

		AopWithSpringPart1Application.createEmployee(e1);
		AopWithSpringPart1Application.createEmployee(e2);
		AopWithSpringPart1Application.createEmployee(e3);
		AopWithSpringPart1Application.createEmployee(e4);
		AopWithSpringPart1Application.createEmployee(e5);
		
		for(int i = 1; i <= 5; i++) {
			AopWithSpringPart1Application.getEmployeeById(Integer.toString(i));
		}
	}

	private static void getEmployeeById(String id) {
		Map < String, String > params = new HashMap < String, String > ();
		params.put("id", id);

		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.getForObject(GET_EMPLOYEE_ENDPOINT_URL, Employee.class, params);

		System.out.println(result);
	}

	private static void createEmployee(Employee employee) {
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(CREATE_EMPLOYEE_ENDPOINT_URL, employee, Employee.class);
		System.out.println(result);
	}
}

package com.Oodles.streamsapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamsApisApplication {

//The use of static in this context is related to the initialization block,
// which is a static block in Java.
//The static block is executed only once when the class is loaded into the memory.
//In this case,it's being used for bootstrapping the employees list with some initial data.

	static List<Employee> employees = new ArrayList<>();

   static {
		employees.add(
				new Employee("Shabbir", "Dawoodi", 5000.0, List.of("Project 1", "Project 2"))
		);
		employees.add(
				new Employee("Nikhil", "Gupta", 6000.0, List.of("Project 1", "Project 3"))
		);
		employees.add(
				new Employee("Shivam", "Kumar", 5500.0, List.of("Project 3", "Project 4"))
		);
	}

	public static void main(String[] args) {

	   SpringApplication.run(StreamsApisApplication.class, args);

	   //for loop
//		for(Employee e:employees) {
//			System.out.println(e);
//		}

//	   employees.stream().forEach(employee -> System.out.println(employee));
	   employees.forEach(System.out::println); //->New method


	//Intermediate Operation
     //map and collections
      List<Employee>employeeList=employees.stream().map(employee -> new Employee(
			  employee.getFirstName(), employee.getLastName(),
			  employee.getSalary()-30,employee.getProjects()
	  )).toList();
      System.out.println(employeeList);

    //filter operation
	List<Employee>employeeList1=employees.stream().filter(employee -> employee.getSalary()>1000 && employee.getFirstName().contains("shabbir"))
				.map(employee -> new Employee(employee.getFirstName(),
						employee.getLastName(),
						employee.getSalary(),
						employee.getProjects()
				)).toList();
		System.out.println(employeeList1);

	//filter operation with first employee
		 Employee employeeOptional = employees.stream().filter(employee->employee.getSalary()>4000)
                .map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary(),
                        employee.getProjects()
                )).findFirst().orElse(null);
		System.out.println(employeeOptional);
   }

	//flatMap
//	String projects =
//			employees
//					.stream()
//					.map(employee -> employee.getProjects())
//					.flatMap(strings -> strings.stream())
//					.collect(Collectors.joining(","));
//        System.out.println(projects);











}
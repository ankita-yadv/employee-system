package com.ankita.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.ems.model.Employee;
import com.ankita.ems.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id){
		return employeeService.getEmployeeByID(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee){
		System.out.println(employee);
		return employeeService.createEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Integer id){
		return employeeService.updateEmployee(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeByID(@PathVariable Integer id){
		employeeService.deleteEmployee(id);
	}
}

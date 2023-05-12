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

import com.ankita.ems.exception.RecordNotFoundException;
import com.ankita.ems.model.Employee;
import com.ankita.ems.service.EmployeeService;


/**
 * Rest controller for the API
 */
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Fetches all employees data
	 * 
	 * @return List of employees
	 */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	/**
	 * Fetch data of an employee
	 * 
	 * @return Employee, if present against the id
	 * @throws RecordNotFoundException
	 */
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) throws RecordNotFoundException {
		return employeeService.getEmployeeByID(id);
	}

	/**
	 * Save the employee data received from the request
	 * 
	 * @return Employee data saved in the DB with the generated id
	 */
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	/**
	 * Update the employee data against the id given
	 * 
	 * @return List of employees
	 * @throws RecordNotFoundException
	 */
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Integer id) throws RecordNotFoundException {
		return employeeService.updateEmployee(id);
	}

	/**
	 * Delete employee data against the id provided if present
	 * 
	 * @throws RecordNotFoundException
	 */
	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeByID(@PathVariable Integer id) throws RecordNotFoundException {
		employeeService.deleteEmployee(id);
	}
}

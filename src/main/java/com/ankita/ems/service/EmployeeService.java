package com.ankita.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankita.ems.exception.RecordNotFoundException;
import com.ankita.ems.model.Employee;
import com.ankita.ems.repository.EmployeeRepository;

/**
 * Service to handle the CRUD operations and perform the database operations
 * using the {@link #employeeRepository}
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Get all employees
	 * 
	 * @return List of employees
	 */
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	/**
	 * Get employee by Id
	 * 
	 * @param id
	 * @return Employee
	 * @throws RecordNotFoundException
	 */
	public Employee getEmployeeByID(Integer id) throws RecordNotFoundException {
		return employeeRepository.findById(id).orElseThrow(
				() -> new RecordNotFoundException("No record for the Employee found with the given id : " + id));
	}

	/**
	 * Save the employee data to DB
	 * 
	 * @param employee - data to save
	 * @return employee record
	 */
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * Updates the employee data
	 * 
	 * @param id
	 * @return Updated Employee
	 * @throws RecordNotFoundException
	 */
	public Employee updateEmployee(Integer id) throws RecordNotFoundException {
		Employee employee = getEmployeeByID(id);
		return employeeRepository.save(employee);
	}

	/**
	 * Deletes the employee data
	 * 
	 * @param id - employee id
	 * @throws RecordNotFoundException
	 */
	public void deleteEmployee(Integer id) throws RecordNotFoundException {
		Employee employee = getEmployeeByID(id);
		employeeRepository.delete(employee);
	}
}

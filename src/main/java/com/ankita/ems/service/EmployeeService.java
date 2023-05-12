package com.ankita.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankita.ems.model.Employee;
import com.ankita.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeByID(Integer id){
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee createEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Integer id){
		Employee employee = getEmployeeByID(id);
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Integer id){
		try {
			Employee employee = getEmployeeByID(id);
			employeeRepository.delete(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

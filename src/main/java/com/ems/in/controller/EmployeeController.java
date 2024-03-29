package com.ems.in.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ems.in.entity.Employee;

import com.ems.in.exception.UserNotFoundException;
import com.ems.in.service.IEmployeeService;

@RestController
@RequestMapping(value= "/employee")

public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
	{
		Employee savedemployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedemployee,HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId) 
			throws UserNotFoundException
	{
		employeeService.deleteEmployee(empId);
			String msg = "User with ID: "+empId+"Deleted Successfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		
		
	}	
	
	@PutMapping(value = "/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee employee)
	{
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String userid)
	{
		Employee employee = employeeService.getEmployeeById(userid);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping(value= "/getALlEmployees")
	public ResponseEntity<Integer> getAllEmployeeCount()
	{
	  return new ResponseEntity<Integer>(employeeService.getAllEmployeeCount(),HttpStatus.OK);
	}
	
}

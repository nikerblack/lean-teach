package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	@GetMapping("/employeSearch")
	public ResponseEntity<List<Employee>> init(@RequestParam(name="name", required = false) String name, @RequestParam(name="postion", required = false) Double position) {
		return new ResponseEntity<>(eService.searchEmployees(name, position), HttpStatus.OK);
	}
}

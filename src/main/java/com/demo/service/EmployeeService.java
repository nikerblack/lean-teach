package com.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	
	public List<Employee> searchEmployees(String name, Double position) {
		
		if(StringUtils.hasText(name) && Objects.nonNull(position)) {
			return repository.findEmployeesByNameAndPosition(name, position);	
		}else if(StringUtils.hasText(name)) {
			return repository.findEmployeesByName(name);
		}else if(Objects.nonNull(position)) {
			return repository.findEmployeesByPosition(name);
		}
		return repository.findAll();

	}
}

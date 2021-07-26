package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.dto.PositionDto;
import com.demo.dto.PositionDto.PositionDtoBuilder;
import com.demo.entity.Employee;
import com.demo.entity.Position;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.PositionRepository;

@Service
public class PositionService {

	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<PositionDto> searchEmployeesByPosition() {
		List<PositionDto> positionDtoList = new ArrayList<>();
		positionRepository.findAll().forEach(dto -> {
			PositionDtoBuilder dtoBuilder = PositionDto.positionDto(dto);
			List<Employee> emp = employeeRepository.findByPosition(dto, Sort.by(Sort.Direction.ASC, "salary"));
			PositionDto postionDto = dtoBuilder.employees(emp).build();
			positionDtoList.add(postionDto);
		});
		return positionDtoList;
	}


}

package com.demo.dto;

import java.util.List;

import com.demo.entity.Employee;
import com.demo.entity.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {

	private int id;
	private String name;
	private List<Employee> employees;
	
	public static PositionDtoBuilder positionDto(Position position) {
		return PositionDto.builder().id(position.getId()).name(position.getName());
	}
	
}

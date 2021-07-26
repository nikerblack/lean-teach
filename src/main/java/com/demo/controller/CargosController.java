package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.dto.PositionDto;
import com.demo.service.PositionService;

@Controller
public class CargosController {

	@Autowired
	private PositionService service;
	
	@GetMapping("/allData")
	public ResponseEntity<List<PositionDto>> init() {
		return new ResponseEntity<>(service.searchEmployeesByPosition(), HttpStatus.OK);
	}
}

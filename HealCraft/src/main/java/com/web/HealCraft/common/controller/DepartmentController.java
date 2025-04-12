package com.web.HealCraft.common.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.DepartmentDisplay;
import com.web.HealCraft.common.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:5175")
public class DepartmentController {
	
	@Autowired
	private DepartmentService department;
	
	@PostMapping("/add-department")
	public ResponseEntity<String> addDepartment(@RequestBody Department dept)
	{
		try
		{
			department.saveDepartment(dept);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("/get-all-department")
	public ResponseEntity<List<Department>> getAllDepartment()
	{
		try
		{
			List<Department> departmentList = department.getAllDepartment();
			return new ResponseEntity<>(departmentList, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ArrayList<Department>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get-active-department")
	public ResponseEntity<List<DepartmentDisplay>> getActiveDepartment()
	{
		try
		{
			List<DepartmentDisplay> departmentList = department.getActiveDepartment();
			return new ResponseEntity<>(departmentList, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ArrayList<DepartmentDisplay>(), HttpStatus.BAD_REQUEST);
		}
	}
	
}












package com.web.HealCraft.common.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.HealCraft.common.dto.Hospital;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.service.HospitalService;
import org.springframework.*;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService hospital;
	
	@PostMapping("/add-hospital")
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospi)
	{
		try
		{
			hospital.saveHospital(hospi);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/get-all-hospitals")
	public List<HospitalEntity>getAllHospitals(){
		return hospital.getAllHospitals();
	}
	
	

}


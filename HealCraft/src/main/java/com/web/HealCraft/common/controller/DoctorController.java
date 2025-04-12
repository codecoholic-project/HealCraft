package com.web.HealCraft.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import com.web.HealCraft.common.dto.Doctor;
import com.web.HealCraft.common.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctor;
	
	@PostMapping("/add-doctor")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doc)
	{
		try
		{
			doctor.saveDoctor(doc);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
		
	}



@GetMapping("/get-all-doctors")
public ResponseEntity<List<Doctor>> getAllDoctors()
{
	try
	{
		List<Doctor> doctors = doctor.getAllDoctors();
		return new ResponseEntity<>(doctors, HttpStatus.OK);
	}
	catch(Exception e)
	{
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
package com.web.HealCraft.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import com.web.HealCraft.common.dto.DoctorRequestDto;
import com.web.HealCraft.common.dto.DoctorResponseDto;
import com.web.HealCraft.common.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:5175")
public class DoctorController {
	
	@Autowired
	private DoctorService doctor;
	
	@PostMapping("/add-doctor")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorRequestDto doc)
	{
		System.out.println("API /add-doctor ");
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
	public ResponseEntity<List<DoctorResponseDto>> getAllDoctors()
	{
		try
		{
			List<DoctorResponseDto> doctors = doctor.getAllDoctors();
			return new ResponseEntity<>(doctors, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/get-doctor/{sid}")
	public ResponseEntity<DoctorResponseDto> getDoctorById(@PathVariable Long sid)
	{
		System.out.println("API /get-doctor/{sid} called with id : "+sid);
		try
		{ 
			DoctorResponseDto doc = doctor.getDoctorById(sid);
			return new ResponseEntity<DoctorResponseDto>(doc, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new DoctorResponseDto(), HttpStatus.BAD_REQUEST);
		}
		
	}
	/*
	@GetMapping("/delete-doctor/{sid}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable Long sid)
	{
		System.out.println("API /delete-doctor/{sid} called with id :"+ sid);
		
		try
		{
			doctor.deleteDoctorById(sid);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("cannot delete", HttpStatus.BAD_REQUEST);
		}
	}
	*/
}
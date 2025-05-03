package com.web.HealCraft.common.controller;

import java.util.ArrayList;
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

import com.web.HealCraft.common.dto.HospitalRequestDto;
import com.web.HealCraft.common.dto.HospitalResponseDto;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.service.HospitalService;


@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "http://localhost:5175")
public class HospitalController {
	
	@Autowired
	private HospitalService hospital;
	
	@PostMapping("/add-hospital")
	public ResponseEntity<String> addHospital(@RequestBody HospitalRequestDto hospi)
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
	public ResponseEntity<List<HospitalResponseDto>> getAllHospitals()
	{
		try
		{
			List<HospitalResponseDto> response = hospital.getAllHospitals();
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ArrayList<HospitalResponseDto>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get-hospital/{sid}")
	public ResponseEntity<HospitalResponseDto> getHospitalById(@PathVariable Long sid)
	{
		System.out.println("API /get-hospital/{sid} called with id : "+sid);
		try
		{
			HospitalResponseDto hospi = hospital.getHospitalById(sid);
			return new ResponseEntity<HospitalResponseDto>(hospi, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new HospitalResponseDto(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/delete-hospital/{sid}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable Long sid)
	{
		System.out.println("API /delete-hospital/{sid} called with id : "+sid);
		
		try
		{
			hospital.deleteHospitalById(sid);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("cannot delete", HttpStatus.BAD_REQUEST);
		}
	}
}


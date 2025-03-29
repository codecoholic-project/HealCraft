package com.web.HealCraft.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.HealCraft.common.dto.Services;
import com.web.HealCraft.common.service.ServicesService;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServicesService service;
	
	@PostMapping("/add-service")
	public ResponseEntity<String> addService(@RequestBody Services serv)
	{
		try
		{
			service.saveService(serv);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
		
	}

}


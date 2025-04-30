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

import com.web.HealCraft.common.dto.Services;
import com.web.HealCraft.common.service.ServicesService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:5175")
public class ServiceController {
	
	@Autowired
	private ServicesService service;
	
	@PostMapping("/add-service")
	public ResponseEntity<String> addService(@RequestBody Services serv)
	{
		System.out.println("API /add-service called with data : "+ serv.toString());
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
	
	@GetMapping("/get-all-services")
	public ResponseEntity<List<Services>> getAllServices()
	{
		try
		{
			List<Services> serviceList = service.getAllService();
			return new ResponseEntity<>(serviceList, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ArrayList<Services>(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get-services/{sid}")
	public ResponseEntity<Services> getServiceById(@PathVariable Long sid)
	{
		System.out.println("API /get-services/{sid} called with id : "+ sid);
		try
		{
			Services serv = service.getServicesById(sid);
			return new ResponseEntity<Services>(serv, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new Services(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/delete-services/{sid}")
	public ResponseEntity<String> deleteServiceById(@PathVariable Long sid)
	{
		System.out.println("API /delete-services/{sid} called with id : "+ sid);
		
		try
		{
			service.deleteServicesById(sid);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("can not delete", HttpStatus.BAD_REQUEST);
		}
	}

}


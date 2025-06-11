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

import com.web.HealCraft.common.dto.PackageDisplay;
import com.web.HealCraft.common.dto.PackageRequestDto;
import com.web.HealCraft.common.dto.PackageResponseDto;
import com.web.HealCraft.common.service.PackageService;


@RestController
@RequestMapping("/package")
@CrossOrigin(origins = "http://localhost:5175")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@PostMapping("/add-package")
	public ResponseEntity<String> addPackage(@RequestBody PackageRequestDto pckg)
	{
		System.out.println("API /add-package, Data : "+ pckg.toString());
		try
		{
			packageService.savePackage(pckg);
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get-all-packages")
	public ResponseEntity<List<PackageResponseDto>> getAllPackages()
	{
		try
		{
			List<PackageResponseDto> packages = packageService.getAllPackages();
			return new ResponseEntity<>(packages, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/get-package/{sid}")
	public ResponseEntity<PackageResponseDto> getPackageById(@PathVariable Long sid)
	{
		System.out.println("API /get-package/{sid} called with id : "+sid);
		try
		{
			PackageResponseDto pckg = packageService.getPackageById(sid);
			return new ResponseEntity<PackageResponseDto>(pckg, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new PackageResponseDto(), HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/delete-package/{sid}")
	public ResponseEntity<String> deletePackageById(@PathVariable Long sid)
	{
		System.out.println("API /delete-package/{sid} called with id : "+sid);
		
		try
		{
			packageService.deletePackageById(sid);
			return new ResponseEntity<>("success", HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("cannot delete", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/get-package-by-hospital-and-department/{deptId}/{hospId}")
	public ResponseEntity<List<PackageDisplay>> getPackageByHospitalAndDepartment(@PathVariable Long deptId,@PathVariable Long hospId)
	{
		System.out.println("API /get-package-by-hospital-and-department/{deptId}/{hospId} called for :");
		try
		{
			List<PackageDisplay> packList = packageService.getPackageByHospitalAndDepartment(hospId, deptId);
			return new ResponseEntity<List<PackageDisplay>>(packList, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
}

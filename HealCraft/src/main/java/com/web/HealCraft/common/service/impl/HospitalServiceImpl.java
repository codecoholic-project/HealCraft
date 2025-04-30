package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DepartmentDao;
import com.web.HealCraft.common.dao.HospitalDao;
import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.HospitalRequestDto;
import com.web.HealCraft.common.dto.HospitalResponseDto;
import com.web.HealCraft.common.entity.DepartmentEntity;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public void saveHospital(HospitalRequestDto hospi) throws Exception
	{
		
		try
		{
			HospitalEntity entity = new HospitalEntity();
			if(hospi.getId() == null)
			{
				entity.setId(null);
			}
			else
			{
				Optional<HospitalEntity> hospitalOptional = hospitalDao.findById(hospi.getId());
				entity = hospitalOptional.get();
			}
			entity.setName(hospi.getName());
			entity.setDescription(hospi.getDescription());
			entity.setAddress(hospi.getAddress());
			entity.setContact(hospi.getContact());
			entity.setEmail(hospi.getEmail());
			entity.setUrl(hospi.getUrl());
			
			List<DepartmentEntity> departments = departmentDao.findAllById(hospi.getDepartmentIds());
			if(departments.size() != hospi.getDepartmentIds().size())
			{
				System.out.println("One or more department IDs are invalid.");
				throw new Exception("One or more department IDs are invalid.");
			}
			
			entity.setDepartments(departments);
			hospitalDao.save(entity);
			
			System.out.println("Hospital Saved Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Invalid");
		}
	}
	
	
	@Override
	public List<HospitalResponseDto> getAllHospitals() throws Exception
	{
		List<HospitalResponseDto> response = new ArrayList<HospitalResponseDto>();
		try
		{
			List<HospitalEntity> entityList = hospitalDao.findAll();
			if(!entityList.isEmpty())
			{
				for(HospitalEntity entity : entityList)
				{
					HospitalResponseDto dto = new HospitalResponseDto();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setDescription(entity.getDescription());
					dto.setAddress(entity.getAddress());
					dto.setContact(entity.getContact());
					dto.setEmail(entity.getEmail());
					dto.setUrl(entity.getUrl());
					List<Department> departments = new ArrayList<Department>();
					entity.getDepartments().forEach(d -> {
						Department dept = new Department();
						dept.setId(d.getId());
						dept.setName(d.getName());
						dept.setDescription(d.getDescription());
						dept.setActive(d.isActive());
						departments.add(dept);
					});
					dto.setDepartments(departments);
					response.add(dto);
				}
			}
			else
			{
				throw new Exception("Data Not Found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
			
		}
		return response;
	}

}

package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.HospitalDao;
import com.web.HealCraft.common.dto.Hospital;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalDao hospitalDao;

	@Override
	public void saveHospital(Hospital hospi) throws Exception{
		
		try
		{
			HospitalEntity entity = new HospitalEntity();
			entity.setId(null);
			entity.setName(hospi.getName());
			entity.setDescription(hospi.getDescription());
			entity.setAddress(hospi.getAddress());
			entity.setContact(hospi.getContact());
			entity.setEmail(hospi.getEmail());
			entity.setUrl(hospi.getUrl());
			
			
			hospitalDao.save(entity);
			
			System.out.println("Hospital Saved Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("0");
		}
	}

}

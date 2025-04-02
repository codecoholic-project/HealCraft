package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DoctorDao;
import com.web.HealCraft.common.dto.Doctor;
import com.web.HealCraft.common.entity.DoctorEntity;
import com.web.HealCraft.common.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;

	@Override
	public void saveDoctor(Doctor doc) throws Exception{
		
		try
		{
			DoctorEntity entity = new DoctorEntity();
			entity.setId(null);
			entity.setName(doc.getName());
			entity.setDegree(doc.getDegree());
			entity.setExperience(doc.getExperience());
			entity.setAbout(doc.getAbout());
			entity.setConsultant(doc.isConsultant());
			entity.setDeptId(doc.getDeptId());
			
			doctorDao.save(entity);
			
			System.out.println("Doctor Saved Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not save");
		}
	}

}
package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DepartmentDao;
import com.web.HealCraft.common.dao.DoctorDao;
import com.web.HealCraft.common.dao.HospitalDao;
import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.DepartmentDisplay;
import com.web.HealCraft.common.dto.DoctorRequestDto;
import com.web.HealCraft.common.dto.DoctorResponseDto;
import com.web.HealCraft.common.dto.HospitalResponseDto;
import com.web.HealCraft.common.entity.DepartmentEntity;
import com.web.HealCraft.common.entity.DoctorEntity;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.service.DoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private HospitalDao hospiDao;

	@Override
	public void saveDoctor(DoctorRequestDto doc) throws Exception{
		
		try
		{
			DoctorEntity entity = new DoctorEntity();
			if(doc.getId() == null)
			{
				entity.setId(null);
				entity.setName(doc.getName());
				entity.setDegree(doc.getDegree());
				entity.setExperience(doc.getExperience());
				entity.setAbout(doc.getAbout());
				entity.setConsultant(doc.isConsultant());
				entity.setDeptId(doc.getDeptId());
				entity.setHospiId(doc.getHospiId());
			}
			else
			{
				Optional<DoctorEntity> docEntity = doctorDao.findById(doc.getId());
				if(docEntity.isPresent())
				{
					entity = docEntity.get();
					entity.setName(doc.getName());
					entity.setDegree(doc.getDegree());
					entity.setExperience(doc.getExperience());
					entity.setAbout(doc.getAbout());
					entity.setConsultant(doc.isConsultant());
					entity.setDeptId(doc.getDeptId());
					entity.setHospiId(doc.getHospiId());
				}
			}
			
			doctorDao.save(entity);
			
			System.out.println("Doctor Saved Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Could not save Doctor");
			e.printStackTrace();
			throw new Exception("Could not save");
		}
	}
	
	@Override
	public List<DoctorResponseDto> getAllDoctors() throws Exception
	{
		List<DoctorResponseDto> doctorList = new ArrayList<DoctorResponseDto>();
		try 
		{
			List<DoctorEntity> entities = doctorDao.findAll();
			for(DoctorEntity entity : entities)
			{
				DoctorResponseDto doc = new DoctorResponseDto();
				doc.setId(entity.getId());
				doc.setName(entity.getName());
				doc.setDegree(entity.getDegree());
				doc.setExperience(entity.getExperience());
				doc.setConsultant(entity.isConsultant());
				doc.setAbout(entity.getAbout());
				Optional<DepartmentEntity> deptEntityOptional = deptDao.findById(entity.getDeptId());
				if(deptEntityOptional.isPresent())
				{
					DepartmentEntity dentity = deptEntityOptional.get();
					DepartmentDisplay dept = new DepartmentDisplay();
					dept.setId(dentity.getId());
					dept.setName(dentity.getName());
					doc.setDepartment(dept);
				}
				
				Optional<HospitalEntity> hospEntityOptional = hospiDao.findById(entity.getHospiId());
				if(hospEntityOptional.isPresent())
				{
					HospitalEntity hentity = hospEntityOptional.get();
					HospitalResponseDto hosp = new HospitalResponseDto();
					hosp.setId(hentity.getId());
					hosp.setName(hentity.getName());
					doc.setHospital(hosp);
				}
				
				/*
				 * doc.setDeptId(entity.getDeptId());
				 *  doc.setHospiId(entity.getHospiId());
				 */
				doctorList.add(doc);
			}
			return doctorList;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("COULD NOT RETRIEVE DOCTORS");
		}
	}
	
	
	@Override
	public DoctorResponseDto getDoctorById(Long sid) throws Exception {
		
		DoctorResponseDto doc = new DoctorResponseDto();
		try
		{
			Optional<DoctorEntity> docEntity = doctorDao.findById(sid);
			if(docEntity.isPresent())
			{
				DoctorEntity entity = docEntity.get();
				doc.setId(entity.getId());
				doc.setName(entity.getName());
				doc.setDegree(entity.getDegree());
				doc.setExperience(entity.getExperience());
				doc.setConsultant(entity.isConsultant());
				doc.setAbout(entity.getAbout());
				Optional<DepartmentEntity> deptEntityOptional = deptDao.findById(entity.getDeptId());
				if(deptEntityOptional.isPresent())
				{
					DepartmentEntity dentity = deptEntityOptional.get();
					DepartmentDisplay dept = new DepartmentDisplay();
					dept.setId(dentity.getId());
					dept.setName(dentity.getName());
					doc.setDepartment(dept);
				}
				Optional<HospitalEntity> hospEntityOptional = hospiDao.findById(entity.getHospiId());
				if(hospEntityOptional.isPresent())
				{
					HospitalEntity hentity = hospEntityOptional.get();
					HospitalResponseDto hosp = new HospitalResponseDto();
					hosp.setId(hentity.getId());
					hosp.setName(hentity.getName());
					doc.setHospital(hosp);
				}	
			}
			else
			{
				throw new NullPointerException();
			}
			return doc;
		}
		catch(NullPointerException en)
		{
			throw new Exception("Given ID is not found");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get doctor");
		}
	}

	/*
	@Override
	public void deleteDoctorById(Long sid) throws Exception {
		
		try
		{
			Optional<DoctorEntity> docEntity = doctorDao.findById(sid);
			if(docEntity.isPresent())
			{
				DoctorEntity entity = docEntity.get();
				doctorDao.delete(entity);
			}
			else
			{
				System.out.println("Doctor ID does not exist.");
				throw new Exception("Doctor ID does not exist.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get doctor");
		}
	}
*/
	
}
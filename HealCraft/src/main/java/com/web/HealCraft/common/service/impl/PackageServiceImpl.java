package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DepartmentDao;
import com.web.HealCraft.common.dao.HospitalDao;
import com.web.HealCraft.common.dao.PackageDao;
import com.web.HealCraft.common.dto.DepartmentDisplay;
import com.web.HealCraft.common.dto.FoodType;
import com.web.HealCraft.common.dto.HospitalDisplay;
import com.web.HealCraft.common.dto.PackageRequestDto;
import com.web.HealCraft.common.dto.PackageResponseDto;
import com.web.HealCraft.common.dto.RoomType;
import com.web.HealCraft.common.entity.DepartmentEntity;
import com.web.HealCraft.common.entity.HospitalEntity;
import com.web.HealCraft.common.entity.PackageEntity;
import com.web.HealCraft.common.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	private PackageDao packageDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public void savePackage(PackageRequestDto pckg) throws Exception{
		
		try
		{
			PackageEntity entity = new PackageEntity();
			if(pckg.getId() == null)
			{
				entity.setName(pckg.getName());
				entity.setPrice(pckg.getPrice());
				entity.setRoomType(RoomType.idFromName(pckg.getRoomType().toString()));
				entity.setFoodType(FoodType.idFromName(pckg.getFoodType().toString()));
				entity.setNurseFacility(pckg.isNurseFacility());
				entity.setPickDrop(pckg.isPickDrop());
				entity.setPhysiotherapy(pckg.isPhysiotherapy());
				entity.setDepartmentId(pckg.getDepartmentId());
				entity.setHospitalId(pckg.getHospitalId());
			}
			else
			{
				Optional<PackageEntity> pckgEntity = packageDao.findById(pckg.getId());
				if(pckgEntity.isPresent())
				{
					entity = pckgEntity.get();
					entity.setName(pckg.getName());
					entity.setPrice(pckg.getPrice());
					entity.setRoomType(RoomType.idFromName(pckg.getRoomType().toString()));
					entity.setFoodType(FoodType.idFromName(pckg.getFoodType().toString()));
					entity.setNurseFacility(pckg.isNurseFacility());
					entity.setPickDrop(pckg.isPickDrop());
					entity.setPhysiotherapy(pckg.isPhysiotherapy());
					entity.setDepartmentId(pckg.getDepartmentId());
					entity.setHospitalId(pckg.getHospitalId());
				}
		}
		
		packageDao.save(entity);
		
		System.out.println("Package saved Successfully");
	}
	catch(Exception e)
		{
			System.out.println("Could not save Package");
			e.printStackTrace();
			throw new Exception("Could not save package");
		}
	
	}
	
	@Override
	public List<PackageResponseDto> getAllPackages() throws Exception 
	{
		List<PackageResponseDto> packageList = new ArrayList<PackageResponseDto>();
		try
		{
			List<PackageEntity> entities = packageDao.findAll();
			for(PackageEntity entity : entities)
			{
				PackageResponseDto pckg = new PackageResponseDto();
				pckg.setId(entity.getId());
				pckg.setName(entity.getName());
				pckg.setPrice(entity.getPrice());
				pckg.setRoomtype(RoomType.nameFromId(entity.getRoomType()));
				pckg.setFoodtype(FoodType.nameFromId(entity.getFoodType()));
				pckg.setNursefacility(entity.isNurseFacility());
				pckg.setPickdrop(entity.isPickDrop());
				pckg.setPhysiotherapy(entity.isPhysiotherapy());
				Optional<DepartmentEntity> deptEntityOptional = departmentDao.findById(entity.getDepartmentId());
				if(deptEntityOptional.isPresent())
				{
					DepartmentEntity dentity = deptEntityOptional.get();
					DepartmentDisplay dept = new DepartmentDisplay();
					dept.setId(dentity.getId());
					dept.setName(dentity.getName());
					pckg.setDepartment(dept);
				}
				Optional<HospitalEntity> hospEntityOptional = hospitalDao.findById(entity.getHospitalId());
				if(hospEntityOptional.isPresent())
				{
					HospitalEntity hentity = hospEntityOptional.get();
					HospitalDisplay hosp = new HospitalDisplay();
					hosp.setId(hentity.getId());
					hosp.setName(hentity.getName());
					pckg.setHospital(hosp);
				}
				packageList.add(pckg);
			}
			return packageList;
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception("COULD NOT RETRIEVE PACKAGES");
		
		}
	}
	
	@Override
	public PackageResponseDto getPackageById(Long sid) throws Exception {
		
		PackageResponseDto pckg = new PackageResponseDto();
		try
		{
			Optional<PackageEntity> pckgEntity = packageDao.findById(sid);
			if(pckgEntity.isPresent())
			{
				PackageEntity entity = pckgEntity.get();
				pckg.setId(entity.getId());
				pckg.setName(entity.getName());
				pckg.setPrice(entity.getPrice());
				pckg.setRoomtype(RoomType.nameFromId(entity.getRoomType()));
				pckg.setFoodtype(FoodType.nameFromId(entity.getFoodType()));
				pckg.setNursefacility(entity.isNurseFacility());
				pckg.setPickdrop(entity.isPickDrop());
				pckg.setPhysiotherapy(entity.isPhysiotherapy());
				Optional<DepartmentEntity> deptEntityOptional = departmentDao.findById(entity.getDepartmentId());
				if(deptEntityOptional.isPresent())
				{
					DepartmentEntity dentity = deptEntityOptional.get();
					DepartmentDisplay dept = new DepartmentDisplay();
					dept.setId(dentity.getId());
					dept.setName(dentity.getName());
					pckg.setDepartment(dept);
				}
				Optional<HospitalEntity> hospEntityOptional = hospitalDao.findById(entity.getHospitalId());
				if(hospEntityOptional.isPresent())
				{
					HospitalEntity hentity = hospEntityOptional.get();
					HospitalDisplay hosp = new HospitalDisplay();
					hosp.setId(hentity.getId());
					hosp.setName(hentity.getName());
					pckg.setHospital(hosp);
				}
			}
			else
			{
				throw new NullPointerException();
			}
			return pckg;
		}
		catch(NullPointerException en)
		{
			throw new Exception("Given ID is not found");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get package");
		}
	}
	@Override
	public void deletePackageById(Long sid) throws Exception {
		try
		{
			Optional<PackageEntity> pckgEntity = packageDao.findById(sid);
			if(pckgEntity.isPresent())
			{
				PackageEntity entity = pckgEntity.get();
				packageDao.delete(entity);
			}
			else
			{
				System.out.println("Package ID does not exist.");
				throw new Exception("Package ID does not exist.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get package");
		}
	}
}



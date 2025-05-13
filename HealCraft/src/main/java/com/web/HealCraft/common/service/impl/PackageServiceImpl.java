package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.PackageDao;
import com.web.HealCraft.common.dto.PackageRequestDto;
import com.web.HealCraft.common.dto.RoomType;
import com.web.HealCraft.common.entity.PackageEntity;
import com.web.HealCraft.common.service.PackageService;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	private PackageDao packageDao;
	
	@Override
	public void savePackage(PackageRequestDto pckg) throws Exception
	{
		try
		{
			PackageEntity entity = new PackageEntity();
			if(pckg.getId() == null)
			{
				entity.setId(null);
			}
			entity.setName(pckg.getName());
			entity.setPrice(pckg.getPrice());
			entity.setRoomtype(RoomType.idFromName(pckg.getRoomtype().toString()));
			//entity.setFoodtype();
			entity.setNursefacility(pckg.isNursefacility());
			entity.setPickdrop(pckg.isPickdrop());
			entity.setPhysiotherapy(pckg.isPhysiotherapy());
			entity.setDepartmentId(pckg.getDepartmentId());
			entity.setHospitalId(pckg.getHospitalId());
			packageDao.save(entity);
			
		}
		catch(Exception e)
		{
			System.out.println("Package insertion failed");
			throw new Exception("Package insertion failed");
		}
		return;
	}

}

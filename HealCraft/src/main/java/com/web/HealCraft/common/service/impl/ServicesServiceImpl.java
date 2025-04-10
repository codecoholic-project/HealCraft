package com.web.HealCraft.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.ServicesDao;
import com.web.HealCraft.common.dto.Services;
import com.web.HealCraft.common.entity.ServiceEntity;
import com.web.HealCraft.common.service.ServicesService;

@Service
public class ServicesServiceImpl implements ServicesService{
	
	@Autowired
	private ServicesDao serviceDao;

	@Override
	public void saveService(Services serv) throws Exception{
		
		try
		{
			ServiceEntity entity = new ServiceEntity();
			entity.setId(null);
			entity.setName(serv.getName());
			entity.setDescription(serv.getDescription());
			entity.setActive(serv.isActive());
			entity.setPrime(serv.isPrime());
			
			serviceDao.save(entity);
			
			System.out.println("Service Saved Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not save");
		}
	}

	@Override
	public List<Services> getAllService() throws Exception {
		
		List<Services> serviceList = new ArrayList<Services>();
		try
		{
			List<ServiceEntity> serviceEntityList = serviceDao.findAll();
			//for(int i = 0; i<serviceEntityList.size(); i++)
			for(ServiceEntity entity : serviceEntityList)
			{
				Services services = new Services();
				services.setId(entity.getId());
				services.setName(entity.getName());
				services.setDescription(entity.getDescription());
				services.setActive(entity.isActive());
				services.setPrime(entity.isPrime());
				serviceList.add(services);
			}
			return serviceList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get services");
		}
	}
	

}

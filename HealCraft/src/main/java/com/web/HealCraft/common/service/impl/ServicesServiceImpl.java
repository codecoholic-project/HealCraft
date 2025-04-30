package com.web.HealCraft.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			if(serv.getId() == null)
			{
				entity.setName(serv.getName());
				entity.setDescription(serv.getDescription());
				entity.setActive(serv.isActive());
				entity.setPrime(serv.isPrime());
			}
			else
			{
				Optional<ServiceEntity> servEntity = serviceDao.findById(serv.getId());
				if(servEntity.isPresent())
				{
					entity = servEntity.get();
					entity.setName(serv.getName());
					entity.setDescription(serv.getDescription());
					entity.setActive(serv.isActive());
					entity.setPrime(serv.isPrime());
				}
				
			}
			
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

	@Override
	public Services getServicesById(Long sid) throws Exception {
		
		Services serv = new Services();
		try
		{
			Optional<ServiceEntity> servEntity = serviceDao.findById(sid);
			if(servEntity.isPresent())
			{
				ServiceEntity entity = servEntity.get();
				serv.setId(entity.getId());
				serv.setName(entity.getName());
				serv.setDescription(entity.getDescription());
				serv.setActive(entity.isActive());
				serv.setPrime(entity.isPrime());
			}
			else
			{
				throw new NullPointerException();
			}
			return serv;
		}
		catch(NullPointerException en)
		{
			throw new Exception("Given ID is not found");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get services");
		}
	}

	@Override
	public void deleteServicesById(Long sid) throws Exception{
		try
		{
			Optional<ServiceEntity> servEntity = serviceDao.findById(sid);
			if(servEntity.isPresent())
			{
				ServiceEntity entity = servEntity.get();
				serviceDao.delete(entity);
			}
			else
			{
				System.out.println("Service ID does not exist.");
				throw new Exception("Service ID does not exist.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get services");
		}
	}
	

}

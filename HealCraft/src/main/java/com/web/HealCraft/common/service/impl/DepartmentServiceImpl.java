package com.web.HealCraft.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DepartmentDao;
import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.entity.DepartmentEntity;
import com.web.HealCraft.common.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public void saveDepartment(Department dept) throws Exception{
	
		try
		{
			DepartmentEntity entity = new DepartmentEntity();
			entity.setId(null);
			entity.setName(dept.getName());
			entity.setDescription(dept.getDescription());
			entity.setActive(dept.isActive());
			
			departmentDao.save(entity);
			
			System.out.println("Department Saved Successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not save");
		}
	}

}













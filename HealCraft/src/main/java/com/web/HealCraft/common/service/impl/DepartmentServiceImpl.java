package com.web.HealCraft.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.HealCraft.common.dao.DepartmentDao;
import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.DepartmentDisplay;
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


	@Override
	public List<Department> getAllDepartment() throws Exception {
		
		List<Department> departmentList = new ArrayList<Department>();
		try
		{
			List<DepartmentEntity> departmentEntityList = departmentDao.findAll();
			//for(int i = 0; i<serviceEntityList.size(); i++)
			for(DepartmentEntity entity : departmentEntityList)
			{
				Department department = new Department();
				department.setId(entity.getId());
				department.setName(entity.getName());
				department.setDescription(entity.getDescription());
				department.setActive(entity.isActive());
				departmentList.add(department);
			}
			return departmentList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get department");
		}
		
	}

	@Override
	public List<DepartmentDisplay> getActiveDepartment() throws Exception {
		
		List<DepartmentDisplay> departmentList =new ArrayList<DepartmentDisplay>();
		try
		{
			List<DepartmentEntity> departmentEntityList = departmentDao.fetchActiveDepartment();
			for(DepartmentEntity entity : departmentEntityList)
			{
				DepartmentDisplay departmentdisplay = new DepartmentDisplay();
				departmentdisplay.setId(entity.getId());
				departmentdisplay.setName(entity.getName());
				
				departmentList.add(departmentdisplay);
			}
			return departmentList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Could not get department");
		}
	}

}













package com.web.HealCraft.common.service;

import java.util.List;

import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.DepartmentDisplay;


public interface DepartmentService {

	public void saveDepartment(Department dept) throws Exception;

	public List<Department> getAllDepartment() throws Exception;
	
	public List<DepartmentDisplay> getActiveDepartment() throws Exception;

}

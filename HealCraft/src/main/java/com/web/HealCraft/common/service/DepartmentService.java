package com.web.HealCraft.common.service;

import java.util.List;

import com.web.HealCraft.common.dto.Department;
import com.web.HealCraft.common.dto.DepartmentDisplay;
import com.web.HealCraft.common.dto.HospitalDisplay;


public interface DepartmentService {

	public void saveDepartment(Department dept) throws Exception;

	public List<Department> getAllDepartment() throws Exception;
	
	public List<DepartmentDisplay> getActiveDepartment() throws Exception;
	
	public Department getDepartmentById(Long sid) throws Exception;
	
	public void deleteDepartmentById(Long sid) throws Exception;

	public List<HospitalDisplay> getHospitalByDepartment(Long deptId) throws Exception;

}

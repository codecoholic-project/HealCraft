package com.web.HealCraft.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.HealCraft.common.entity.DepartmentEntity;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Long>{
	
	@Query("SELECT d FROM DepartmentEntity d WHERE d.active = true")
	public List<DepartmentEntity> fetchActiveDepartment();
	
	@Query(nativeQuery = true, value = "select id, name from hospital h, hospital_department hd where h.id = hd.hospital_id and hd.department_id = :deptId")
	public List<Object[]> fetchActiveHospitalsByDepartment(@Param(value = "deptId") Long deptId);

}








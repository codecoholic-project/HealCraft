package com.web.HealCraft.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.web.HealCraft.common.entity.DepartmentEntity;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Long>{
	
	@Query("SELECT d FROM DepartmentEntity d WHERE d.active = true")
	public List<DepartmentEntity> fetchActiveDepartment();

}








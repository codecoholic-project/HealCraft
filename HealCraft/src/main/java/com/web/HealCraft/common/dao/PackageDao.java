package com.web.HealCraft.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.web.HealCraft.common.entity.PackageEntity;

@Repository
public interface PackageDao extends JpaRepository<PackageEntity, Long> {
	
	@Query("SELECT p FROM PackageEntity p WHERE p.hospitalId = :hospId AND p.departmentId = :deptId")
	public List<PackageEntity> getpackageByHospitalAndDepartment(@Param(value = "hospId") Long hospId, @Param(value = "deptId") Long deptId);

}

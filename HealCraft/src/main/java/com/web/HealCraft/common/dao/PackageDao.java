package com.web.HealCraft.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.HealCraft.common.entity.PackageEntity;

@Repository
public interface PackageDao extends JpaRepository<PackageEntity, Long> {

}

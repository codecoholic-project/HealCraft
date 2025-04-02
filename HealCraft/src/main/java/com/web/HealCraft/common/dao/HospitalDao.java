package com.web.HealCraft.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.HealCraft.common.entity.HospitalEntity;

@Repository
public interface HospitalDao extends JpaRepository<HospitalEntity, Long>{

}

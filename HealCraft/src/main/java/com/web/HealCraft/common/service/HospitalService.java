package com.web.HealCraft.common.service;

import com.web.HealCraft.common.dto.Hospital;
import com.web.HealCraft.common.entity.HospitalEntity;

import java.util.List;
public interface HospitalService {
	
	public void saveHospital(Hospital hospi) throws Exception;
	List<HospitalEntity>getAllHospitals();

}

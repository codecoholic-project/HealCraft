package com.web.HealCraft.common.service;

import java.util.List;

import com.web.HealCraft.common.dto.HospitalRequestDto;
import com.web.HealCraft.common.dto.HospitalResponseDto;
public interface HospitalService {
	
	public void saveHospital(HospitalRequestDto hospi) throws Exception;
	
	public List<HospitalResponseDto> getAllHospitals() throws Exception;

}

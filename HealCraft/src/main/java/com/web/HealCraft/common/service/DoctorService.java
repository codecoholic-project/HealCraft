package com.web.HealCraft.common.service;

import com.web.HealCraft.common.dto.DoctorRequestDto;
import com.web.HealCraft.common.dto.DoctorResponseDto;
import com.web.HealCraft.common.dto.Services;

import java.util.List;

public interface DoctorService {
	
	public void saveDoctor(DoctorRequestDto doc) throws Exception;
	
	List<DoctorResponseDto> getAllDoctors() throws Exception;
	
	
	 public DoctorResponseDto getDoctorById(Long sid) throws Exception;
	 
	  public void deleteDoctorById(Long sid) throws Exception;
	 

}

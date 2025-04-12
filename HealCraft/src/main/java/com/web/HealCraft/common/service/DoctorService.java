package com.web.HealCraft.common.service;

import com.web.HealCraft.common.dto.Doctor;
import java.util.List;

public interface DoctorService {
	
	public void saveDoctor(Doctor doc) throws Exception;
	
	List<Doctor>getAllDoctors() throws Exception;

}

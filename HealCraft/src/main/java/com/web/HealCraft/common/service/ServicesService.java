package com.web.HealCraft.common.service;

import java.util.List;

import com.web.HealCraft.common.dto.Services;

public interface ServicesService {
	
	public void saveService(Services serv) throws Exception;
	
	public List<Services> getAllService() throws Exception;

	public Services getServicesById(Long sid) throws Exception;

}

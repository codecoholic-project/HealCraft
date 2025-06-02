package com.web.HealCraft.common.service;

import com.web.HealCraft.common.dto.PackageRequestDto;
import com.web.HealCraft.common.dto.PackageResponseDto;

import java.util.List;

public interface PackageService {

	public void savePackage(PackageRequestDto pckg) throws Exception;
	List<PackageResponseDto> getAllPackages() throws Exception;
	
	public PackageResponseDto getPackageById(Long sid) throws Exception;
	public void deletePackageById(Long sid) throws Exception;
}

package com.web.HealCraft.common.service;

import com.web.HealCraft.common.dto.PackageRequestDto;

public interface PackageService {

	void savePackage(PackageRequestDto pckg) throws Exception;

}

package com.uber.driver.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uber.driver.dtos.DriverDto;
import com.uber.driver.entities.DriverEntity;
import com.uber.driver.repositories.DriverRepository;

@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepository;

	public DriverDto saveDriver(DriverDto driverDto) {
		DriverEntity driverEntity = new DriverEntity();
		driverEntity.setName(driverDto.getName());
		driverEntity.setEmail(driverDto.getEmail());
		driverEntity.setAddress(driverDto.getAddress());
		driverEntity.setPhone(driverDto.getPhone());
		driverEntity.setDriverLicense(driverDto.getDriverLicenseNo());
		driverEntity.setCreatedAt(new Date());
		driverEntity.setUpdatedAt(new Date());
		
		driverRepository.save(driverEntity);
		driverDto.setId(driverEntity.getId());
		return driverDto;
	}
}
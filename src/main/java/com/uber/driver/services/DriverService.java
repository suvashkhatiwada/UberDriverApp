package com.uber.driver.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uber.driver.dtos.DriverDto;
import com.uber.driver.dtos.VehicleDto;
import com.uber.driver.entities.DriverEntity;
import com.uber.driver.entities.VehicleEntity;
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
	
	@Transactional
	public DriverDto getDriverDetails(Integer id) {
		DriverEntity driverEntity = driverRepository.findById(id);
		DriverDto driverDto = new DriverDto();
		if(driverEntity != null) {
			driverDto.setId(driverEntity.getId());
			driverDto.setName(driverEntity.getName());
			driverDto.setEmail(driverEntity.getEmail());
			driverDto.setAddress(driverEntity.getAddress());
			driverDto.setPhone(driverEntity.getPhone());
			
			List<VehicleDto> vehicles = new ArrayList<VehicleDto>(); 
			for(VehicleEntity v : driverEntity.getVehicles()) {
				VehicleDto vehicleDto = new VehicleDto();
				vehicleDto.setId(v.getId());
				vehicleDto.setLicensePlate(v.getLicensePlate());
				vehicleDto.setMake(v.getMake());
				vehicleDto.setModel(v.getModel());
				vehicleDto.setVin(v.getVin());
				vehicleDto.setYear(v.getYear());
				
				vehicles.add(vehicleDto);
			}
		}
		return driverDto;
	}
}
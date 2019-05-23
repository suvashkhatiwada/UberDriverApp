package com.uber.driver.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uber.driver.dtos.VehicleDto;
import com.uber.driver.entities.DriverEntity;
import com.uber.driver.entities.VehicleEntity;
import com.uber.driver.repositories.DriverRepository;
import com.uber.driver.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private DriverRepository driverRepository;
	
	@Transactional
	public VehicleDto save(VehicleDto vehicleDto, Integer driverId) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setVin(vehicleDto.getVin());
		vehicleEntity.setMake(vehicleDto.getMake());
		vehicleEntity.setModel(vehicleDto.getModel());
		vehicleEntity.setYear(vehicleDto.getYear());
		vehicleEntity.setLicensePlate(vehicleDto.getLicensePlate());
		vehicleEntity.setCreatedAt(new Date());
		vehicleEntity.setUpdatedAt(new Date());
		
		DriverEntity driver = driverRepository.findById(driverId);
		vehicleEntity.setDriver(driver);
		vehicleRepository.save(vehicleEntity);
		
		vehicleDto.setId(vehicleEntity.getId());
		vehicleDto.setDriverId(driverId);
		return vehicleDto;
		// TODO veriify using sms
	}
	
	@Transactional
	public VehicleDto getVehicleDetails(Integer id) {
		VehicleEntity vehicleEntity = vehicleRepository.findById(id);
		VehicleDto vehicleDto = new VehicleDto();
		if(vehicleEntity != null) {
			vehicleDto.setId(vehicleEntity.getId());
			vehicleDto.setLicensePlate(vehicleEntity.getLicensePlate());
			vehicleDto.setMake(vehicleEntity.getMake());
			vehicleDto.setModel(vehicleEntity.getModel());
			vehicleDto.setVin(vehicleEntity.getVin());
			vehicleDto.setYear(vehicleEntity.getYear());
			vehicleDto.setDriverId(vehicleEntity.getDriver().getId());
		}
		
		return vehicleDto;
	}

	
}
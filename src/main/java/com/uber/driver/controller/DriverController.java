package com.uber.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uber.driver.dtos.DriverDto;
import com.uber.driver.dtos.VehicleDto;
import com.uber.driver.services.DriverService;
import com.uber.driver.services.VehicleService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public DriverDto createDriver(@RequestBody DriverDto driverDto) {
		return driverService.saveDriver(driverDto);
	}
	
	@RequestMapping(value="/{driverId}/vehicle", method = RequestMethod.POST)
	public VehicleDto addVehicle(@RequestBody VehicleDto vehicleDto, 
			@PathVariable(value = "driverId") Integer driverId) {
		return vehicleService.save(vehicleDto, driverId);
	}
	
	@RequestMapping(value="/{driverId}", method = RequestMethod.GET)
	public DriverDto getDriver(@PathVariable Integer driverId) {
		return driverService.getDriverDetails(driverId);
	}
}
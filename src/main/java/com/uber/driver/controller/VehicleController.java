package com.uber.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uber.driver.dtos.VehicleDto;
import com.uber.driver.services.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value="/{vehicleId}", method = RequestMethod.GET)
	public VehicleDto getVehicle(@PathVariable Integer vehicleId) {
		return vehicleService.getVehicleDetails(vehicleId);
	}
}

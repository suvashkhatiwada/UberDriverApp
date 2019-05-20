package com.uber.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uber.driver.dtos.DriverDto;
import com.uber.driver.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createDriver(@RequestBody DriverDto driverDto) {
		driverService.saveDriver(driverDto);
	}
	
}
package project.cmm.myccm.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.cmm.myccm.core.model.request.FopRequest;
import project.cmm.myccm.core.model.response.FopResponse;

@Service
public class FopService {

	
	
	public FopResponse startFopProcess(FopRequest request) {
		if (!request.isTest()) {
			checkRequestParameter(request);
		}
		
		createXmlFileForFopProcess();
		
		
		return null;
	}
	
	
	
	private void checkRequestParameter(FopRequest request) {
		if (request.getFirstName() == null || request.getFirstName().isEmpty() || request.getFirstName().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer first name is not available!");
		}
		if (request.getLastName() == null || request.getLastName().isEmpty() || request.getLastName().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer last name is not available!");
		}
		if (request.getStreetName() == null || request.getStreetName().isEmpty() || request.getStreetName().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer street name is not available!");
		}
		if (request.getStreetNumber() == null || request.getStreetNumber().isEmpty() || request.getStreetNumber().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer street number is not available!");
		}
		if (request.getZip() == null || request.getZip().isEmpty() || request.getZip().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer ZIP code is not available!");
		}
		if (request.getCity() == null || request.getCity().isEmpty() || request.getCity().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Customer city is not available!");
		}
		if (request.getBrand() == null || request.getBrand().isEmpty() || request.getBrand().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle brand is not available!");
		}
		if (request.getModelName() == null || request.getModelName().isEmpty() || request.getModelName().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle model is not available!");
		}
		if (request.getManufactureYear() == null || request.getManufactureYear().isEmpty() || request.getManufactureYear().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle manufacture year is not available!");
		}
		if (request.getMileage() >= 1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle mileage is not available!");
		}
		if (request.getMotorNumber() == null || request.getMotorNumber().isEmpty() || request.getMotorNumber().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle motor number is not available!");
		}
		if (request.getChassisNumber() == null || request.getChassisNumber().isEmpty() || request.getChassisNumber().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle chassis number is not available!");
		}
	}
	
	private void createXmlFileForFopProcess() {
		
	}
}

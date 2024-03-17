package project.cmm.myccm.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.core.model.request.FopRequest;
import project.cmm.myccm.core.model.response.FopResponse;
import project.cmm.myccm.core.model.xml.Customer;
import project.cmm.myccm.core.model.xml.Document;
import project.cmm.myccm.core.model.xml.Vehicle;
import project.cmm.myccm.fop.logic.XmlWriter;

@Service
public class FopService {

	@Value("${xml.file.path}")
	private String xmlFileDir;

	public FopResponse startFopProcess(FopRequest request, CompanyDto company) {

		if (!request.isTest()) {
			checkRequestParameter(request);
			Document document = createDocumentFromRequest(request, company);
			try {
				String documentPath = createXmlFileForFopProcess(document);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

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
		if (request.getStreetNumber() == null || request.getStreetNumber().isEmpty()
				|| request.getStreetNumber().isBlank()) {
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
		if (request.getManufactureYear() == null || request.getManufactureYear().isEmpty()
				|| request.getManufactureYear().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle manufacture year is not available!");
		}
		if (request.getMileage() >= 1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle mileage is not available!");
		}
		if (request.getMotorNumber() == null || request.getMotorNumber().isEmpty()
				|| request.getMotorNumber().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle motor number is not available!");
		}
		if (request.getChassisNumber() == null || request.getChassisNumber().isEmpty()
				|| request.getChassisNumber().isBlank()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The vehicle chassis number is not available!");
		}
	}

	private Document createDocumentFromRequest(FopRequest request, CompanyDto company) {

		Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getStreetName(),
				request.getStreetNumber(), request.getZip(), request.getCity());
		Customer seller = new Customer(company.getName(), "", company.getStreetName(), company.getStreetNumber(),
				company.getZip(), company.getCity());
		Vehicle vehicle = new Vehicle(request.getVehicleType().name(), request.getBrand(), request.getModelName(),
				request.getManufactureYear(), request.getMileage(), request.getModelName(), request.getChassisNumber());
		String formattedTime = "";
		if (request.isWithDate()) {
			LocalDateTime currentTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			formattedTime = currentTime.format(formatter);
		}

		Document document = new Document(seller, customer, vehicle, request.getCity(), formattedTime);

		return document;
	}

	private String createXmlFileForFopProcess(Document document) throws Exception {
		XmlWriter writer = new XmlWriter(xmlFileDir);
		return writer.writeXml(document);

	}
}

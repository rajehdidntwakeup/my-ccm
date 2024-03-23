package project.cmm.myccm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import project.cmm.myccm.core.model.Address;
import project.cmm.myccm.core.model.Company;
import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.repository.CompanyRepository;

public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CompanyService.class);
	
	public long saveCompany(CompanyDto companyDto) {
		try {
			Address address = new Address();
			address.setCountry("Austria");
			address.setCity(companyDto.getCity());
			address.setStreetName(companyDto.getStreetName());
			address.setStreetNumber(companyDto.getStreetNumber());
			address.setZip(companyDto.getZip());
			Company company = new Company();
			company.setName(companyDto.getName());
			company.addAddress(address);
			company = companyRepository.save(company);
			return company.getCompanyId();
		} catch (Exception e) {
			logger.error("Error while saving company: ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}

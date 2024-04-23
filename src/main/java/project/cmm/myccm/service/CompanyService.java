package project.cmm.myccm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.cmm.myccm.core.model.Address;
import project.cmm.myccm.core.model.Company;
import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.repository.AddressRepository;
import project.cmm.myccm.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	private static Logger logger = LoggerFactory.getLogger(CompanyService.class);
	
	public long saveCompany(CompanyDto companyDto) {
		try {
			Company company = new Company();
			company.setName(companyDto.getName());
			company = companyRepository.save(company);

			Address address = new Address();
			address.setCountry("Austria");
			address.setCity(companyDto.getCity());
			address.setStreetName(companyDto.getStreetName());
			address.setStreetNumber(companyDto.getStreetNumber());
			address.setZip(companyDto.getZip());
			address.setCompany(company);
			addressRepository.save(address);
			
			return company.getCompanyId();
		} catch (Exception e) {
			logger.error("Error while saving company: ", e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	public CompanyDto getCompanyInfo() {
		CompanyDto companyDto = null;
		Company company = companyRepository.findAll().get(0);
		if (company != null) {
			Address address = company.getAddresses().get(0);
			if (address != null) {
				companyDto = new CompanyDto(company.getName(), address.getStreetName(), address.getStreetNumber(),
						address.getZip(), address.getCity());
			} else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Address not found!");
			}
		}
		return companyDto;

	}

}

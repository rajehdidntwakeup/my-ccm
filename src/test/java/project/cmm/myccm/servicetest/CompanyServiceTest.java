package project.cmm.myccm.servicetest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import project.cmm.myccm.core.model.Address;
import project.cmm.myccm.core.model.Company;
import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.repository.CompanyRepository;
import project.cmm.myccm.service.CompanyService;

@SpringBootTest
@ActiveProfiles("mem")
public class CompanyServiceTest {

	@Autowired
	private CompanyService service;
	
	@Autowired
	private CompanyRepository repository;
	
	
	@Test
	public void saveCompanyTest() {
		CompanyDto company = new CompanyDto("Test", "street", "11/2", "1123", "Wien");
		assertDoesNotThrow(()-> service.saveCompany(company));
		List<Company> companies = repository.findAll();
		assertTrue(!companies.isEmpty());
		Address address = companies.get(0).getAddresses().get(0);
		assertEquals("street", address.getStreetName());
		assertEquals("1123", address.getZip());
		
	}
}

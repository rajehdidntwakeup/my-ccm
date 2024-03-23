package project.cmm.myccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.service.CompanyService;

@RestController
@RequestMapping(path = "/comp")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	public ResponseEntity<String> saveCompany(@RequestBody CompanyDto companyDto) {
		long companyID = companyService.saveCompany(companyDto);
		if (companyID > 0) {
			return new ResponseEntity<String>("Company with ID: " + companyDto + " saved!", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
	}
	
}

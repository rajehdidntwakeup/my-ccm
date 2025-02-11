package project.cmm.myccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cmm.myccm.core.model.dto.CompanyDto;
import project.cmm.myccm.service.CompanyService;

@RestController
@RequestMapping(path = "/comp/")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "save")
    public ResponseEntity<String> saveCompany(@RequestBody CompanyDto companyDto) {
        long companyID = companyService.saveCompany(companyDto);
        if (companyID > 0) {
            return new ResponseEntity<String>("Company with ID: " + companyID + " saved!", HttpStatus.OK);
        }

        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

    }


    @GetMapping(path = "info")
    public ResponseEntity<CompanyDto> getCompanyInfo() {
        CompanyDto companyDto = companyService.getCompanyInfo();

        if (companyDto != null) {
            return new ResponseEntity<CompanyDto>(companyDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<CompanyDto>(HttpStatus.NOT_FOUND);
        }
    }

}

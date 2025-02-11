package project.cmm.myccm.controllertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import project.cmm.myccm.controller.CompanyController;
import project.cmm.myccm.core.model.dto.CompanyDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("mem")
public class CompanyControllerTest {

    @Autowired
    private CompanyController controller;


    @Test
    public void saveCompanyTest() {
        CompanyDto company = new CompanyDto("Test", "street", "11/2", "1123", "Wien");
        ResponseEntity<String> response = controller.saveCompany(company);
        HttpStatusCode httpStatusCode = response.getStatusCode();
        String responseBody = response.getBody();
        assertEquals(HttpStatusCode.valueOf(200), httpStatusCode);
        assertEquals("Company with ID: 1 saved!", responseBody);

    }
}

package project.cmm.myccm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import project.cmm.myccm.fop.logic.FopProcessLogic;
import project.cmm.myccm.fop.logic.XmlWriter;
import project.cmm.myccm.repository.CompanyUserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FopService {

    private static Logger logger = LoggerFactory.getLogger(FopService.class);
    @Autowired
    private CompanyUserRepository companyUserRepository;
    @Value("${xml.file.path}")
    private String xmlFileDir;

    public FopResponse startFopProcess(FopRequest request, long companyId) {
        CompanyDto company = getCompanyDto(companyId);
        FopProcessLogic fopProcess = new FopProcessLogic();

        if (!request.isTest()) {
            logger.info("Starting a creating document process...");
            checkRequestParameter(request);
            Document document = createDocumentFromRequest(request, company);
            try {
                String documentXmlPath = createXmlFileForFopProcess(document);
                //TODO
                fopProcess.startFopProcess(null, documentXmlPath, null, null);
            } catch (Exception e) {
                logger.error("Error: ", e);
            }
        }
        return null;
    }

    /**
     * Checks the validity of request parameters for a FopRequest object. Throws
     * ResponseStatusException with HttpStatus.BAD_REQUEST if any required parameter
     * is missing or invalid.
     *
     * @param request the FopRequest object to be checked
     * @throws ResponseStatusException if any required parameter is missing or
     *                                 invalid
     */
    private void checkRequestParameter(FopRequest request) {
        logger.info("Checking request parameter...");
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


    private CompanyDto getCompanyDto(long companyId) {
        CompanyDto companyDto = companyUserRepository.getCompanyDtoById(companyId);
        return companyDto;
    }

    /**
     * Creates a document from the given FopRequest and CompanyDto objects.
     * <p>
     * Constructs a Customer object representing the buyer using data from the
     * request. Constructs a Customer object representing the seller using data from
     * the CompanyDto object. Constructs a Vehicle object using details from the
     * request. If the request specifies including the date, retrieves the current
     * date and formats it. Constructs a Document object using the seller, buyer,
     * vehicle, city, and formatted time.
     *
     * @param request the FopRequest object containing customer and vehicle details
     * @param company the CompanyDto object containing seller details
     * @return the Document object created from the request and company information
     */
    private Document createDocumentFromRequest(FopRequest request, CompanyDto company) {

        logger.info("Creating a document object for XML File..");
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


    /**
     * Creates an XML file for the FOP process using the provided Document object.
     * <p>
     * Instantiates an XmlWriter object with the specified XML file directory.
     * Writes XML content based on the provided Document object using the XmlWriter.
     *
     * @param document the Document object containing data to be written into the XML file
     * @return the path to the created XML file
     * @throws Exception if an error occurs during XML file creation
     */
    private String createXmlFileForFopProcess(Document document) throws Exception {
        XmlWriter writer = new XmlWriter(xmlFileDir);
        return writer.writeXml(document);
    }

}

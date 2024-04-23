package project.cmm.myccm.xmlwriter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import project.cmm.myccm.core.model.xml.Customer;
import project.cmm.myccm.core.model.xml.Document;
import project.cmm.myccm.core.model.xml.Vehicle;
import project.cmm.myccm.fop.logic.XmlWriter;

public class XmlWriterTest {
	
	private final String filePath = "./src/test/resources/xmlfiles/";
	
	
	private Document init() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String date = dateFormat.format(new Date());
		Customer seller = new Customer("Jack", "Boo", "Testgasse", "11", "1170", "Vienna");
		Customer customer = new Customer("Bop", "Foo", "Teststreet", "12", "1220", "Vienna");
		Vehicle vehicle = new Vehicle("PKW", "Audi", "A7", "2022", 10000, "218358", "AS-937629", 5000);
		
		return new Document(seller, customer, vehicle, "Wien", date);
	}

	@Test
	public void writeXmlTest() {
		
		XmlWriter xmlWriter = new XmlWriter(filePath);
		Document document = init();
		assertDoesNotThrow(()-> xmlWriter.writeXml(document));
		Path path = Paths.get(filePath + "/document.xml");
		assertTrue(Files.exists(path));
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				fail();
			}
		}
		
	}
}

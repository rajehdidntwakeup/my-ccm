package project.cmm.myccm.xmlwriter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
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

	private Document init() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String date = dateFormat.format(new Date());
		Customer seller = new Customer("Jack", "Boo", "Testgasse", "11", "1170", "Vienna");
		Customer customer = new Customer("Bop", "Foo", "Teststreet", "12", "1220", "Vienna");
		Vehicle vehicle = new Vehicle("PKW", "Audi", "A7", "2022", 10000, "218358", "AS-937629", 50000);

		return new Document(seller, customer, vehicle, "Wien", date);
	}

	@Test
	public void writeXmlTest() {
		// Step 1: Initialize the XML document
		Document document = init();

		// Step 2: Define a temporary file path for testing
		Path outputDir = Paths.get("target/test-output/xmlfiles");
		Path tempFilePath = outputDir.resolve("document.xml");

		try {
			// Ensure the parent directory exists
			Files.createDirectories(outputDir);

			// Step 3: Write the XML document to the file
			XmlWriter xmlWriter = new XmlWriter(outputDir.toString());
			assertDoesNotThrow(() -> xmlWriter.writeXml(document), "Writing XML should not throw an exception");

			// Step 4: Verify the file was created
			File file = tempFilePath.toFile();
			assertTrue(file.exists(), "File should exist after writing XML");

			// Step 5: (Optional) Verify the content of the file if needed
			// You can read the file and validate its content here

		} catch (IOException e) {
			fail("Failed to create directories or write XML file: " + e.getMessage());
		} finally {
			// Step 6: Clean up the file after the test
			try {
				Files.deleteIfExists(tempFilePath);
			} catch (IOException e) {
				System.err.println("Failed to delete temporary file: " + e.getMessage());
			}
		}
	}
}
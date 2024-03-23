package project.cmm.myccm.fop.logic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class FopProcessLogic {
	
	private static Logger logger = LoggerFactory.getLogger(FopProcessLogic.class);
	

	public void startFopProcess(String xslFilePath, String inputXmlFilePath, String fopConfigFilePath,
			String outputFilePath) {

		FopFactory fopFactory = null;
		try {
			logger.info("Preparing for FOP process..");
			fopFactory = FopFactory.newInstance(new File(fopConfigFilePath));
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(outputFilePath)));

			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, outputStream);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			Source source = new StreamSource(new File(xslFilePath));
			Result result = new SAXResult(fop.getDefaultHandler());
			logger.info("Starting a FOP transformation process..");
			transformer.transform(source, result);
			
		} catch (SAXException | IOException | TransformerException e) {
			logger.error("Error in FOP transformation process: ", e);
		}
	}
}

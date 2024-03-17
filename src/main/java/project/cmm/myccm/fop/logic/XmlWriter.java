package project.cmm.myccm.fop.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import project.cmm.myccm.core.model.xml.Document;

public class XmlWriter {

	private String xmlFileDir;
	private static XMLOutputFactory outputFactory;
	public static JAXBContext context;

	static {
		try {
			context = JAXBContext.newInstance(Document.class);
			outputFactory = XMLOutputFactory.newFactory();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * Constructor.
	 *
	 * @param xmlFileDir
	 */
	public XmlWriter(String xmlFileDir) {
		super();
		this.xmlFileDir = xmlFileDir;
	}


	public String writeXml(Document document) throws Exception {
		try {
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			File xmlFile = new File(this.xmlFileDir + "/" + "document.xml");
			OutputStream outputStream = new FileOutputStream(xmlFile);
			Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.ISO_8859_1);
			XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(writer); 
			streamWriter.writeStartDocument("ISO-8859-1", "1.0");
			marshaller.marshal(document, streamWriter);
			streamWriter.close();
			writer.close();
			outputStream.close();
			return xmlFile.getAbsolutePath();
		} catch (JAXBException | IOException | XMLStreamException e) {
			// TODO: Exception handling
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
}

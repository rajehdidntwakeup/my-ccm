package project.cmm.myccm.fop.logic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class FopProcessLogic {

	public void startFopProcess(String xslFilePath, String inputXmlFilePath, String fopConfigFilePath,
			String outputFilePath) {

		try {
			FopFactory fopFactory = FopFactory.newInstance(new File(fopConfigFilePath));

			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(outputFilePath)));
			
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, outputStream);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fopCallParameter = "";
	}

}

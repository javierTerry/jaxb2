package net.valdo.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.valdo.xml.cfdi.Comprobante;
import net.valdo.xml.cfdi.Comprobante.Emisor;


public class JaxbCfdi {
	
	private static final String XML_FILE = "cfdi3.3.xml";
	
	public static void main(String[] args) throws JAXBException,
    FileNotFoundException {
	
		
		
		
		Emisor emisor = new Comprobante.Emisor();
		emisor.setNombre("christian Hernandez");
		
		Comprobante comprobante = new Comprobante();
		
		comprobante.setVersion(XML_FILE);
		comprobante.setSerie("AA");
		comprobante.setEmisor(emisor);
	
		
		// create JAXB context
		JAXBContext context = JAXBContext.newInstance(Comprobante.class);
		
		System.out.println("<!----------Generating the XML Output-------------->");
		// Marshalling [Generate XML from JAVA]
		// create Marshaller using JAXB context
		Marshaller m = context.createMarshaller();
		// To format the [to be]generated XML output
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Marshall it and write output to System.out or to a file
		m.marshal(comprobante, System.out);
		m.marshal(comprobante, new File(XML_FILE));
		
		
		System.out.println("<!---------------Generating the Java objects from XML Input-------------->");
		// UnMarshalling [Generate JAVA from XML]
		// Instantiate Unmarshaller via context
		Unmarshaller um = context.createUnmarshaller();
		// Unmarshall the provided XML into an object
		Comprobante cfdi = (Comprobante) um.unmarshal(new FileReader(XML_FILE));
		System.out.println("Serie :" + cfdi.getSerie());

	}

}

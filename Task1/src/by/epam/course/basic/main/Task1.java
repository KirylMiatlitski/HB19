package by.epam.course.basic.main;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class Task1 {

	public static void main(String[] args) {
		boolean flag = true;
		try{
			validate("src/by/epam/course/basic/main/SportProducts.xml", "src/by/epam/course/basic/main/SportProducts.xsd");
		} 
		catch (SAXException e){
			System.out.println(e);
			flag=false;}
		catch (IOException e){flag=false;
		System.out.println(e);}
		System.out.println("Xml file is valid: "+flag);

	}
	
	public static void validate(String xmlFile, String xsdFile) throws SAXException, IOException{
		SchemaFactory fact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		(fact.newSchema(new File(xsdFile))).newValidator().validate(new StreamSource(new File(xmlFile)));
		
	}
}

package nl.nutstree;

import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class UntrustedXml {
    public static void main(String[] args) throws SAXException, IOException {
        StreamSource source = new StreamSource(new File("dummy"));
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema();
        Validator validator = schema.newValidator();
        validator.validate(source);
    }

}
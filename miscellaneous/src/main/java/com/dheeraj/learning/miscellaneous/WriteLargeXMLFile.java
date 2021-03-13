package com.dheeraj.learning.miscellaneous;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLargeXMLFile {
    public static void main(String[] args) {
        WriteLargeXMLFile obj = new WriteLargeXMLFile();
        obj.writeFile();
    }

    public void writeFile() {
        XMLOutputFactory factory     = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileWriter("C:\\dev\\output\\output2.xml"));

            writer.writeStartDocument();
            writer.writeStartElement("document");
            writer.writeStartElement("data");
            writer.writeAttribute("name", "value");
            writer.flush();
            writer.writeCharacters("test");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

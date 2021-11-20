import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import xml.XMLLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLLoaderTest {
    @Test
    public void checkXMLLoaderTest() throws ParserConfigurationException, IOException, SAXException {
        String fileName = "test.xml";
        File file = new File(fileName);
        XMLWorkWithFile.createFile(fileName);
        XMLWorkWithFile.updateFile(fileName, "<test>123</test>");

        XMLLoader xmlLoader = new XMLLoader();
        Document doc1 = xmlLoader.load(fileName);
        doc1.getDocumentElement().normalize();

        //Here comes the root node
        Element element1 = doc1.getDocumentElement();
        System.out.println(element1.getTextContent());

        element1.setTextContent("abc");

        xmlLoader.setFileVersion(file.lastModified());

        Document doc2 = xmlLoader.load(fileName);
        doc2.getDocumentElement().normalize();

        //Here comes the root node
        Element element2 = doc2.getDocumentElement();
        System.out.println(element2.getTextContent());
    }
}

class XMLWorkWithFile{
    public static void createFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void updateFile(String fileName, String addString) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(addString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
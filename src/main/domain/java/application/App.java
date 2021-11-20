package application;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.XMLLoader;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Document doc = new XMLLoader().load("src/sources/config.xml");
        doc.getDocumentElement().normalize();

        //Here comes the root node
        Element root = doc.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get all users
        NodeList nList = doc.getElementsByTagName("user");
        System.out.println("============================");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                //Print each employee's detail
                Element eElement = (Element) node;

                System.out.println("First Name : "  + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Age : "   + eElement.getElementsByTagName("age").item(0).getTextContent());
                System.out.println("SecretKey : "   + eElement.getElementsByTagName("secret-key").item(0).getTextContent());

            }
        }
    }
}

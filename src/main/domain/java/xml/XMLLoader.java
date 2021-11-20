/*
@param xml contains xml Document
@param fileVersion contains the last Date of changes of xml File
if the xml property is null - then it should load the doc from the file
if the xml property is not null and the stored last modification date differs from the one of the actual file, then again - it should load the doc from the file
if the xml property is not null and the file was not modified meanwhile, then the load method can return the data from the xml property, without loading it again from the source file
 */

package xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLLoader {
    private Document xml;
    private long fileVersion;

    public  Document load(String fileName) throws ParserConfigurationException, IOException, SAXException {

        File file = new File(fileName);

        if (xml != null && fileVersion == file.lastModified())
            return xml;

        else{
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            xml = docBuilder.parse(new File(fileName));
            fileVersion = file.lastModified();
        }
        return xml;
    }

    public long getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(long fileVersion) {
        this.fileVersion = fileVersion;
    }
}

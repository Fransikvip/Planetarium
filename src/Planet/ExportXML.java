package Planet;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class ExportXML {

    private static final String xmlFilePath = "D:\\xmlfile.xml"; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private List<Characteristic> characteristics;

    public ExportXML(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public void export() {

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("root");
            document.appendChild(root);

            for (Characteristic characteristic : characteristics) {
                Element planet = document.createElement("planet");
                root.appendChild(planet);

                Attr name = document.createAttribute("name");
                name.setValue(characteristic.getPlanet());
                planet.setAttributeNode(name);

                Element moonCount = document.createElement("moonCount");
                moonCount.appendChild(document.createTextNode(String.valueOf(characteristic.getMoonCount())));
                planet.appendChild(moonCount);

                Element totalWeight = document.createElement("totalWeight");
                totalWeight.appendChild(document.createTextNode(String.valueOf(characteristic.getTotalWeight())));
                planet.appendChild(totalWeight);

                Element moonWeight = document.createElement("moonWeight");
                moonWeight.appendChild(document.createTextNode(String.valueOf(characteristic.getMoonWeight())));
                planet.appendChild(moonWeight);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
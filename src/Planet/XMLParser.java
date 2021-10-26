package Planet;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    public List<Planet> parse() {
        ArrayList<Planet> planets = new ArrayList<>();

        File file = new File("test.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            Document document = factory.newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();

            NodeList planetNodes = document.getElementsByTagName("planet");

            for (int i = 0; i < planetNodes.getLength(); i++) {
                Node planetNode = planetNodes.item(i);

                if (planetNode.getNodeType() == Node.ELEMENT_NODE) {
                    String planetName = ((Element) planetNode).getElementsByTagName("name").item(0).getTextContent();
                    String planetWeight = ((Element) planetNode).getElementsByTagName("weight").item(0).getTextContent();

                    NodeList moonNodes = ((Element) planetNode).getElementsByTagName("moon");

                    ArrayList<Moon> moons = new ArrayList<>();
                    for (int j = 0; j < moonNodes.getLength(); j++) {
                        Node moonNode = moonNodes.item(i);
                        if (planetNode.getNodeType() == Node.ELEMENT_NODE) {
                            String moonName = ((Element) moonNode).getElementsByTagName("name").item(0).getTextContent();
                            String moonWeight = ((Element) moonNode).getElementsByTagName("weight").item(0).getTextContent();

                            moons.add(new Moon(moonName, Integer.valueOf(moonWeight)));
                        }
                    }

                    planets.add(new Planet(planetName, Integer.valueOf(planetWeight), moons));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return planets;
    }
}

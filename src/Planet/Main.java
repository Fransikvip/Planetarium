package Planet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        XMLParser parser = new XMLParser();
        List<Planet> planets = parser.parse();

        ArrayList<Characteristic> characteristics = new ArrayList<>();
        for (Planet planet : planets) {
            Characteristic characteristic = new Characteristic();
            characteristic.setPlanet(planet.getName());
            characteristic.setMoonCount(planet.getMoons().size());

            int moonsWeight = 0;
            for (Moon moon : planet.getMoons()) {
                moonsWeight = moonsWeight + moon.getWeight();
            }

            characteristic.setMoonWeight(moonsWeight);
            characteristic.setTotalWeight(moonsWeight + planet.getWeight());

            characteristics.add(characteristic);
        }

        ExportXML exportXML = new ExportXML(characteristics);
        exportXML.export();
    }
}

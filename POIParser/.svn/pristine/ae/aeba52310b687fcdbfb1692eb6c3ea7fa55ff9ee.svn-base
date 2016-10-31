package ca.ubc.cpsc210.sustainabilityapp.model.parser;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
import org.xml.sax.helpers.DefaultHandler;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;

public class MapInfoParser extends DefaultHandler {
	
	private List<PointOfInterest> reg;

    private PointOfInterest pointOfInterest;

    private StringBuffer accumulator;


	public MapInfoParser(List<PointOfInterest> reg) {
		this.reg = reg;
	}


    @Override
    public void startDocument() {

        System.out.println("Start Document!");

        accumulator = new StringBuffer();
    }


    @Override
    public void startElement(String namespaceURI, String localName,
             String qName, Attributes atts) {

        System.out.println("StartElement: " + qName);

        if (qName.toLowerCase().equals("poi")) {
            pointOfInterest = new PointOfInterest(atts.getValue("Id"),
                    atts.getValue("DisplayName"));

            System.out.println("Created a new poi with Id = "
                    + atts.getValue("Id"));

            System.out.println("Created a new poi with Display Name = "
                    + atts.getValue("DisplayName"));
        }
            accumulator.setLength(0);
    }


    public void characters(char[] temp, int start, int length) {

        accumulator.append(temp, start, length);
    }



    public void endElement(String uri, String localName, String qName) {
        String data = accumulator.toString().trim();

        System.out.println("EndElement: " + qName + " value: " + data);

        if (qName.toLowerCase().equals("address")) {
            pointOfInterest.setAddress(data);
        }

        else if (qName.toLowerCase().equals("lat")) {
            LatLong origLatLong = pointOfInterest.getLatLong();
            LatLong newLat;
            if (origLatLong == null) {
                newLat = new LatLong(Double.parseDouble(data), 0);
            }

            else {
                newLat = new LatLong(Double.parseDouble(data), pointOfInterest.getLatLong().getLongitude());
            }

            pointOfInterest.setLatLong(newLat);

        }

        else if (qName.toLowerCase().equals("long")) {
            LatLong origLatLong = pointOfInterest.getLatLong();
            LatLong newLong;
            if (origLatLong == null) {
                newLong = new LatLong(0, Double.parseDouble(data));
            }

            else {

                newLong = new LatLong(pointOfInterest.getLatLong().getLatitude(), Double.parseDouble(data));
            }
            pointOfInterest.setLatLong(newLong);

        }
        else if (qName.toLowerCase().equals("description")) {
            pointOfInterest.setDescription(data);
        }

        else if (qName.toLowerCase().equals("feature")) {
            Feature feature = Feature.parseFeature(data);
            List<Feature> features = pointOfInterest.getFeatures();
            if (features == null) {
                features = new ArrayList<Feature>();
            }
                features.add(feature);

            pointOfInterest.setFeatures(features);

        }

        else if (qName.toLowerCase().equals("poi")) {
            reg.add(pointOfInterest);
        }
        accumulator.setLength(0);

    }

    public void endDocument() {

        System.out.println("End Document!");
    }
}



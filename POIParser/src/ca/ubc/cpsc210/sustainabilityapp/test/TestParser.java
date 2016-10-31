package ca.ubc.cpsc210.sustainabilityapp.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;
import ca.ubc.cpsc210.sustainabilityapp.model.parser.MapInfoParser;

public class TestParser {
	private static final double DELTA = 1.0e-6;   // for testing doubles
	private List<PointOfInterest> reg;
	private PointOfInterest first;
	private PointOfInterest last;
	
	@Before
	public void setUp() {
		reg = new ArrayList<PointOfInterest>();
		
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new MapInfoParser(reg));
			reader.parse("UBC-Sustainability-MapInfo.xml");
			
			first = reg.get(0);
			last = reg.get(reg.size() - 1);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNumPOIs() {
		assertEquals(7, reg.size());
	}
	
	@Test
	public void testIdFirst() {
		assertEquals("Law", first.getId());
	}
	
	@Test
	public void testIdLast() {
		assertEquals("LSC", last.getId());
	}
}

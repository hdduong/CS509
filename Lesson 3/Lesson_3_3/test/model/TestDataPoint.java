package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDataPoint {

	@Test
	public void testDataPoint() {
		DataPoint dataPoint = new DataPoint(2.0,5.0);
		
		assertEquals(true, dataPoint.getX() == 2.0);
		assertEquals(true, dataPoint.getY() == 5.0);
		
		assertEquals(true, dataPoint.toString().equals("2.0,5.0"));
	}

}

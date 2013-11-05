package model;

import junit.framework.TestCase; 

public class TestDataPoint extends TestCase{

	 
	public void testDataPointInit(){
		DataPoint dp = new DataPoint(3,4);
		assertEquals(true,dp.x==3);
		assertEquals(true,dp.y==4);
	}
	
}

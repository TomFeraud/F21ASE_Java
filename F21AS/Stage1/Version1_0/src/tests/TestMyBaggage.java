package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import F21ASE_Stage1.Baggage;

public class TestMyBaggage {
	
    private Baggage baggage1;
    private Baggage baggage2;
    private Baggage baggage3;
    
    @Before
	public void setUp() {
    	baggage1 = new Baggage(20.0,12.90,11.8,19.32);
		baggage2 = new Baggage(30.0, 10.0,8.0,1.0);
		baggage3 = new Baggage(20.10, 12.0,18.0,5.0);
	}
    
	@Test
    public void testcalculateDimT(){
    	double dimensionT1 = 2940.89;
    	double dimensionT2 = 80.0;
    	double testMethod1 = baggage1.calculateDimT(baggage1.getDimensionX(),baggage1.getDimensionY(),baggage1.getDimensionZ());
    	assertEquals(dimensionT1,testMethod1,0.001);
    	double testMethod2 = baggage2.calculateDimT(baggage2.getDimensionX(),baggage2.getDimensionY(),baggage2.getDimensionZ());
    	assertEquals(dimensionT2,testMethod2,0.001);
    }
    
	@Test
	public void testcalculateBagFee()
	{
		double bagFee1 = 0.0;
		double bagFee2 = 50.0;
		double bagFee3 = 0.5;
		double testMethod1 = baggage1.calculateBagFee();
		double testMethod2 = baggage2.calculateBagFee();
		double testMethod3 = baggage3.calculateBagFee();
    	assertEquals(bagFee1,testMethod1,0.001);
    	assertEquals(bagFee2,testMethod2,0.001);
    	assertEquals(bagFee3,testMethod3,0.001);
		
	}
}

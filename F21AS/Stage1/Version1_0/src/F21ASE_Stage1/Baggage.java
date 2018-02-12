package F21ASE_Stage1;


public class Baggage {
    private double weight;
    private double dimensionX;
    private double dimensionY;
    private double dimensionZ;
    private double dimensionT;
    public static double excessBagFee;
    
    //faire javadoc + les tests
    
    /**
     * Constructor of Baggage with the weight and dimensions
     * @param weight
     * @param dimensionX
     * @param dimensionY
     * @param dimensionZ
     */
    public Baggage(double weight, double dimensionX, double dimensionY, double dimensionZ) {
        this.weight = weight;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.dimensionZ = dimensionZ;
    }
    
    public double calculateDimT(double dimensionX, double dimensionY, double dimensionZ)
    {
    	dimensionT= dimensionX * dimensionY * dimensionZ;
    	dimensionT= Math.round(dimensionT*100.0)/100.0;
    	return dimensionT;
    }
    
    public double calculateBagFee(double weight)
    {
    	if (weight < 20)
    	{
    		excessBagFee = 0;
    	}
    	else
    	{
    		excessBagFee = (weight - 20) * 5; //£5 per extra kg
    		excessBagFee = Math.round(excessBagFee *100.0)/100.0;
    	}
    	return excessBagFee;
    }
    
    
    public double getWeight() {
        return Math.round(weight *100.0)/100.0;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getDimensionX() {
        return dimensionX;
    }
    
    public void setDimensionX(double dimensionX) {
        this.dimensionX = dimensionX;
  
    }
    
    public double getDimensionY() {
        return dimensionY;
    }
    
    public void setDimensionY(double dimensionY) {
        this.dimensionY = dimensionY;
    }
    
    public double getDimensionZ() {
        return dimensionZ;
    }
    
    public void setDimensionZ(double dimensionZ) {
        this.dimensionZ = dimensionZ;
    }
    
    
    public String toString() {
    	if (calculateBagFee(weight)>0)
    	{
    		return "\n Baggage's weight: " +getWeight() +"kg, baggage dimension:" 
            		+calculateDimT(dimensionX, dimensionY, dimensionZ) +"cm^3, excess baggage fee: £" 
            		+calculateBagFee(weight);
    	}
    	else
    	{
    		return "\n Baggage's weight: " +getWeight() +"kg, baggage dimension:" 
            		+calculateDimT(dimensionX, dimensionY, dimensionZ) +"cm^3";
    	}
        
    }
    
}

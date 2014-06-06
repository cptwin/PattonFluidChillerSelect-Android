package com.pattonnz.pattonfluidchillerselect;

/**
 *
 * @author MingHsuan Lee, Dajne Win
 */
public enum F_Type {

    //12/12/2013 Dajne Win, Changed Lowest Water Temp from 4 to 2
    WATER("Water", 4.185, 2),
    PG1("Propylene Glycol 10%", 4.102, -2),
    PG2("Propylene Glycol 20%", 4.018, -6),
    PG3("Propylene Glycol 30%", 3.913, -12),
    PG4("Propylene Glycol 40%", 3.746, -20),
    EG1("Ethylene Glycol 10%", 4.001, -2),
    EG2("Ethylene Glycol 20%", 3.911, -7),
    EG3("Ethylene Glycol 30%", 3.821, -13),
    EG4("Ethylene Glycol 40%", 3.599, -23),
    Unknown("Unknown Type", 0.0, 0);
    private String name;
    private double v;
    private int lowestAllowedTemp;

    private F_Type(String name, double v, int lowestAllowedTemp) {
        this.name = name;
        this.v = v;
        this.lowestAllowedTemp = lowestAllowedTemp;
    }

    /**
     * Returns the Fluid Type given the string representation.
     * @param name
     * @return Fluid Type F_Type
     */
    public static F_Type getTypeFromName(String name) {
    	if(name.equals("Water"))
    	{
    		return F_Type.WATER;
    	} else if(name.equals("Propylene Glycol 10%"))
    	{
    		return F_Type.PG1;
    	} else if(name.equals("Propylene Glycol 20%"))
    	{
    		return F_Type.PG2;
    	} else if(name.equals("Propylene Glycol 30%"))
    	{
    		return F_Type.PG3;
    	} else if(name.equals("Propylene Glycol 40%"))
    	{
    		return F_Type.PG4;
    	} else if(name.equals("Ethylene Glycol 10%"))
    	{
    		return F_Type.EG1;
    	} else if(name.equals("Ethylene Glycol 20%"))
    	{
    		return F_Type.EG2;
    	} else if(name.equals("Ethylene Glycol 30%"))
    	{
    		return F_Type.EG3;
    	} else if(name.equals("Ethylene Glycol 40%"))
    	{
    		return F_Type.EG4;
    	}
    	else
    	{
    		return F_Type.Unknown;
    	}
    }

    /**
     * Returns the name of the Fluid Type
     * @return String Name of Fluid Type
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the value of the Fluid Type used when calculating capacity.
     * @return double Calculation Value
     */
    public double getValue() {
        return this.v;
    }

    /**
     * Returns the lowest temperature that the Fluid Type may be used for calculations.
     * @return int Lowest Allowable Temperature
     */
    public int getlowestAllowedTemp() {
        return this.lowestAllowedTemp;
    }

    @Override
    public String toString() {
        return getName();
    }
}

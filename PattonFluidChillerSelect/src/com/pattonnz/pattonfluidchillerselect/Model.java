package com.pattonnz.pattonfluidchillerselect;

/**
 *
 * @author MingHsuan Lee, Dajne Win
 */
public class Model {

    private F_Type fluidType;
    private double tempIn;
    private double tempOut;
    private double volume;
    private double runTime;
    private Engine[] engines;
    private double capacity;
    
    private static String selectedModel = "";

    public Model(String typeName, int tempIn, int tempOut, int volume, int runTime) {
        this.fluidType = F_Type.getTypeFromName(typeName);
        this.tempIn = (double) tempIn;
        this.volume = (double) volume;
        this.tempOut = (double) tempOut;
        this.runTime = (double) runTime;
        this.engines = Engine.values();
        this.capacity = calculate();
    }

    private double calculate() {
        double result = 0.0;
        result = volume * fluidType.getValue() * (tempIn - tempOut) / (runTime * 3.6) / 1000;
        return result;
    }

    public void printEngine() {
        for (Engine temp : engines) {
            System.out.println(temp.toString());
            System.out.println(temp.getValueArray().length);
            int t = -20;
            for (double d : temp.getValueArray()) {
                System.out.println("" + t + " : " + d);
                ++t;
            }
            System.out.println("");
        }
    }

    public String findEngine() {
        if (!validTempOut()) {
            return "ERROR Fluid Out temp is too low for " + fluidType.getName();
        } else if(tempOut > tempIn){
            return "ERROR Input temp is higher than output!";
        }
        
        int position = (int) tempOut - 6 + 20;
        boolean choose = true;
        Engine temp = null;
        try {
        for (int i = 0; i < engines.length && choose; i++) {
            temp = engines[i];
            if (temp.getValueArray()[position] >= capacity) {
                choose = false;
            }
        }
        } catch (ArrayIndexOutOfBoundsException ex)
        {
            return "ERROR No models in database meet Criteria";
        }
        //if the capacity is larger than the maximum capacity of the engine
        if(capacity > temp.getValueArray()[temp.getValueArray().length-1]){
            temp = null;        
        }
        if (temp == null) {
            return "ERROR No models in database meet Criteria";
        } else {
            return temp.toString();
        }
    }

    public double getCapacity() {
        return this.capacity;
    }

    public boolean validTempOut() {
        if(compare(tempOut,fluidType.getlowestAllowedTemp()) < 0)
        {
           return false;
        } else {
            return true;
        }
    }

    private int compare(double d, int i) { 	
        return Double.valueOf(d).compareTo(Double.valueOf(i));
    }
    
    public static String getSelectedModel()
    {
    	return selectedModel;
    }
    
    public static void setSelectModel(String model)
    {
    	selectedModel = model;
    }
}

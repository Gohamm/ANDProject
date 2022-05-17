package com.example.converterapp.UnitConversionModels;

import java.text.NumberFormat;

public class LengthConversion {

    //meters will act as the base value - every other unit will have a vale corresponding to 1 meter
    final double meters = 1;
    final double centimeters = 100;
    final double kilometers = 0.001;
    final double millimeters = 1000;
    final double inches = 39.37;
    final double feet = 3.28;
    final double yards = 1.09;
    final double miles = 0.0006214;


    private double userInput;
    private double conversionOutput;
    private String From_Unit;
    private String To_Unit;



    // constructor
    public LengthConversion () {
        userInput = 0;
        conversionOutput = 0;
        From_Unit = "";
        To_Unit = "";
    }

    public double getUserInput() {
        return userInput;
    }

    public void setUserInput(double userInput) {
        this.userInput = userInput;
    }

    public double getConversionOutput() {
        return conversionOutput;
    }

    public void setConversionOutput(double conversionOutput) {
        this.conversionOutput = conversionOutput;
    }

    public String getFrom_Unit() {
        return From_Unit;
    }

    public void setFrom_Unit(String from_Unit) {
        From_Unit = from_Unit;
    }

    public String getTo_Unit() {
        return To_Unit;
    }

    public void setTo_Unit(String to_Unit) {
        To_Unit = to_Unit;
    }

    // get the type of unit based on value
    public double getUnitType (String unitType) {
        if (unitType == "meters") {
            return meters;
        }
        if (unitType == "kilometers") {
            return kilometers;
        }
        if (unitType == "centimeters") {
            return centimeters;
        }
        if (unitType == "millimeters") {
            return millimeters;
        }
        if (unitType == "inches") {
            return inches;
        }
        if (unitType == "feet") {
            return feet;
        }
        if (unitType == "yards") {
            return yards;
        }
        if (unitType == "miles") {
            return miles;
        }
        return 0;
    }


    public double calculateOutput () {
        double userInput = getUserInput();
        double conversionOutput = getConversionOutput();
        double From_unit = getUnitType(getFrom_Unit());
        double To_unit = getUnitType(getTo_Unit());

        conversionOutput = meters/From_unit; //convert to base value "meters"
        conversionOutput = conversionOutput * To_unit; // convert from base value
        conversionOutput = conversionOutput * userInput; // multiply by user input to get the final output

        return conversionOutput;

    }

    public String toString () {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();

        if (To_Unit.equals("yards") || To_Unit.equals("feet") || To_Unit.equals("inches")) {
            numberFormatter.setMaximumFractionDigits(2);
        } else {
            numberFormatter.setMaximumFractionDigits(4);
        }
        return numberFormatter.format(getConversionOutput() + " " + getTo_Unit());
    }




}

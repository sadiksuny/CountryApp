package com.example.lab3.model;

public class Country {
    public String countryName;
    public String countryRegion;
    public int countryPopulation;


    public Country(){

    }
    public Country(String countryName, String countryRegion, int countryPopulation){
        this.countryName= countryName;
        this.countryRegion= countryRegion;
        this.countryPopulation=countryPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public int getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(int countryPopulation) {
        this.countryPopulation = countryPopulation;
    }
}

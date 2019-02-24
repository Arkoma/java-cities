package com.lambdaschool.cities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {

    private static @Id @GeneratedValue Long id;
    private String cityAndStateName;
    private double medianHomePrice;
    private int affordabilityIndex;

    public City(String cityAndStateName, double medianHomePrice, int affordabilityIndex) {
        this.cityAndStateName = cityAndStateName;
        this.medianHomePrice = medianHomePrice;
        this.affordabilityIndex = affordabilityIndex;
    }

    public City() {
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        City.id = id;
    }

    public String getCityAndStateName() {
        return cityAndStateName;
    }

    public void setCityAndStateName(String cityAndStateName) {
        this.cityAndStateName = cityAndStateName;
    }

    public double getMedianHomePrice() {
        return medianHomePrice;
    }

    public void setMedianHomePrice(double medianHomePrice) {
        this.medianHomePrice = medianHomePrice;
    }

    public int getAffordabilityIndex() {
        return affordabilityIndex;
    }

    public void setAffordabilityIndex(int affordabilityIndex) {
        this.affordabilityIndex = affordabilityIndex;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityAndStateName='" + cityAndStateName + '\'' +
                ", medianHomePrice=" + medianHomePrice +
                ", affordabilityIndex=" + affordabilityIndex +
                '}';
    }
}

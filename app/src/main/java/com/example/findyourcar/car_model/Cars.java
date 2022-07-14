package com.example.findyourcar.car_model;

public class Cars {
    private String creator;
    private String model;
    private  int value;
    private  int year;
    private int CarResource;

    public Cars(String creator, String model, int value, int year, int carResource) {
        this.creator = creator;
        this.model = model;
        this.value = value;
        this.year = year;
        CarResource = carResource;
    }

    public String getCreator() {
        return creator;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getValue() {
        return value;
    }

    public int getYear() {
        return year;
    }


    public int getCarResource() {
        return CarResource;
    }

}

package org.rd99.model;
public class Car{
    private final String color;
    private final String registrationNumber;

    public Car(String color , String registrationNumber){
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber(){
        return registrationNumber;
    }
    public  String getColor(){
        return color;
    }

        }
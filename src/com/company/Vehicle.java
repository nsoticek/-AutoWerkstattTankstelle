package com.company;

public abstract class Vehicle {

    public Enum brand;
    public int horsePower;
    public int kilometre;
    public int kilometreToService;
    public int fuel;
    public String fuelType;
    public int tires;
    public Person person;

    public Vehicle(Enum brand, int horsePower, int kilometre, int kilometreToService, int fuel, String fuelType, int tires, Person person) {
        this.brand = brand;
        this.horsePower = horsePower;
        this.kilometre = kilometre;
        this.kilometreToService = kilometreToService;
        this.fuel = fuel;
        this.fuelType = fuelType;
        this.tires = tires;
        this.person = person;
    }

    public abstract void drive(int distance);
}

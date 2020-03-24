package com.company;

public class Car extends Vehicle {

    public Car(Enum brand, int horsePower, int kilometre, int kilometreToService, int fuel, String fuelType, int tires, Person person) {
        super(brand, horsePower, kilometre, kilometreToService, fuel, fuelType, tires, person);
        this.brand = brand;
        this.horsePower = horsePower;
        this.kilometre = kilometre;
        this.kilometreToService = kilometreToService;
        this.fuel = fuel;
        this.fuelType = fuelType;
        this.tires = tires;
        this.person = person;
    }

    @Override
    public void drive(int distance) {
        this.fuel = (int) (this.fuel - (distance * 0.2));
        this.tires = (int) (this.tires - (distance * 0.2));
        this.kilometre = this.kilometre + distance;
        this.kilometreToService -= distance;

        if (this.fuel < 5) {
            System.out.println("ACHTUNG! - Tank steht unter 5% - Weiterfahren nicht mehr möglich");
        }
        if (this.tires < 5) {
            System.out.println("ACTUNG! - Reifenzustand ist unter 5% - Weiterfahren nicht mehr möglich");
        }
        if (this.kilometreToService <= 10) {
            System.out.println("Das Auto benötigt einen Service. Bitte sofort in die Werkstatt fahren!");
        }
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public int getKilometreToService() {
        return kilometreToService;
    }

    public void setKilometreToService(int kilometreToService) {
        this.kilometreToService = kilometreToService;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getTires() {
        return tires;
    }

    public void setTires(int tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return brand +
                "\n Leistung: " + horsePower +
                "\n km: " + kilometre +
                "\n km bis Service: " + kilometreToService +
                "\n Tankanzeige: " + fuel + " % " +
                "\n Reifenzustand: " + tires + " %\n";
    }
}

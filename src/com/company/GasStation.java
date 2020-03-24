package com.company;

public class GasStation {

    private String company;
    private double petrolPrice;
    private double dieselPrice;
    private double invoiceAmount;

    public GasStation(String company, double petrolPrice, double dieselPrice) {
        this.company = company;
        this.petrolPrice = petrolPrice;
        this.dieselPrice = dieselPrice;
    }

    public double refuel(Vehicle vehicle, int quantity) {
        vehicle.fuel = vehicle.fuel + quantity;
        double fuelPrice = getFuelPrice(vehicle);
        invoiceAmount = quantity * fuelPrice;

        double money = vehicle.person.getMoney() - invoiceAmount;
        vehicle.person.setMoney(money);

        return invoiceAmount;
    }

    private double getFuelPrice(Vehicle vehicle) {
        double fuelPrice = 0;
        if(vehicle.fuelType.equals("Diesel")) {
            fuelPrice = this.getDieselPrice();
        } else if(vehicle.fuelType.equals("Benzin")) {
            fuelPrice = this.getPetrolPrice();
        }
        return fuelPrice;
    }

    public double getPetrolPrice() {
        return petrolPrice;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }
}

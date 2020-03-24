package com.company;

public class Garage {

    private String garageName;
    private double servicePrice;
    private double changeTiresPrice;

    public Garage(String garageName, double servicePrice, double changeTiresPrice) {
        this.garageName = garageName;
        this.servicePrice = servicePrice;
        this.changeTiresPrice = changeTiresPrice;
    }

    public double service(Vehicle vehicle) {
        vehicle.kilometreToService+= vehicle.kilometreToService;
        double invoiceAmount = this.getServicePrice();
        double money = vehicle.person.getMoney() - invoiceAmount;
        vehicle.person.setMoney(money);

        return invoiceAmount;
    }

    public double changeTires(Vehicle vehicle) {
        vehicle.tires = 100;
        double invoiceAmount = this.getChangeTiresPrice();
        double money = vehicle.person.getMoney() - invoiceAmount;
        vehicle.person.setMoney(money);

        return invoiceAmount;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public double getChangeTiresPrice() {
        return changeTiresPrice;
    }

    public void setChangeTiresPrice(double changeTiresPrice) {
        this.changeTiresPrice = changeTiresPrice;
    }
}

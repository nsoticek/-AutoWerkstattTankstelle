package com.company;

public class Person {

    private String name;
    private double money;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " Kontostand: " + money;
    }
}

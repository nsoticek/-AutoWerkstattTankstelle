package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Person newPerson = getUserInputCreatePerson();

        Car car = new Car(CarTypes.MERCEDES_BENZ_G63, 465, 2000, 2000,20,
                "Benzin", 45, newPerson);
        GasStation omv = new GasStation("OMV", 1.25, 1.09);
        Garage newGarage = new Garage("Best Garage", 950, 500);

        while (true) {
            mainMenue(car, omv, newPerson, newGarage);
        }
    }

    private static void mainMenue(Car car, GasStation omv, Person newPerson, Garage newGarage) {
        /*MainMenu in console; The user can make a selection here;
        Possible selections: drive, refuel, service,changeTire, view userFacts*/

        Scanner scanner = new Scanner(System.in);
        double invoiceAmount;
        String messageDrive = "Wie viel km willst du fahren? ";
        String messageRefuel = "Wie viel Prozent soll ich dir dazutanken? ";

        System.out.println("Menü" + "\n1. Autofahren" + "\n2. Tanken" + "\n3. Werkstatt Service" +
                "\n4. Werkstatt Reifen wechsel" + "\n5. Infos über Auto abrufen" +
                "\n6. Infos zur Person abrufen");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1: // Drive
                int distance = getUserInputNumber(messageDrive, scanner);
                car.drive(distance);
                break;
            case 2: // Refuel
                int quantitiy = getUserInputNumber(messageRefuel, scanner);
                invoiceAmount = omv.refuel(car, quantitiy);
                createInvoice(invoiceAmount, car.fuelType, quantitiy, newPerson, car);
                break;
            case 3: // Service
                invoiceAmount = newGarage.service(car);
                createInvoice(invoiceAmount, "Service", 1, newPerson, car);
                break;
            case 4: // change Tires
                invoiceAmount = newGarage.changeTires(car);
                createInvoice(invoiceAmount, "Reifenwechsel", 4, newPerson, car);
                break;
            case 5: // Car person
                System.out.println(car);
                break;
            case 6: // Info person
                System.out.println(newPerson);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    private static int getUserInputNumber(String messageDrive, Scanner scanner) {
        System.out.println(messageDrive);
        int distance = scanner.nextInt();
        return distance;
    }

    private static Person getUserInputCreatePerson() {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        System.out.println("Wie ist dein Name: ");
        String name = scannerStr.nextLine();
        System.out.println("Wie hoch ist dein Kontostand: ");
        int balance = scannerNum.nextInt();

        Person newPerson = new Person(name, balance);
        return newPerson;
    }

    private static void createInvoice(double invoiceAmount, String purpose, int quantitiy, Person newPerson, Car car) {
        System.out.println("---------Rechnung----------");
        System.out.printf("%s\t\t%dl\t\t%.2f€\n", purpose, quantitiy, invoiceAmount);
        System.out.printf("----------------------------");
        System.out.printf("\nGesamt\t\t\t\t%.2f€\n", invoiceAmount);
        System.out.println("----------------------------");

        createInvoiceInFile(invoiceAmount, purpose, quantitiy, newPerson, car);
    }

    private static void createInvoiceInFile(double invoiceAmount, String purpose, int quantitiy, Person newPerson, Car car) {

        String myFile = "..\\Übung 4 -AutoRechnung\\src\\com\\company\\Invoice.txt";

        try {
            FileWriter fileWriter = new FileWriter(myFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String str = "\n" + newPerson.getName() + ";" + car.getBrand() + ";" + purpose + ";" + invoiceAmount;
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

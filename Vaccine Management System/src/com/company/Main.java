package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        mainMenu();
    }

    public static void mainMenu(){
        System.out.println("---->  Main Menu  <----");
        System.out.println("[1]- StockMenu");
        System.out.println("[2]- Patient Menu");
        System.out.println("[0]- Exit System");
        System.out.println("---------------");
        VaccineMangement vm = new VaccineMangement();
        vm.getAllVaccines();
        short choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Choice: ");

            choice = input.nextShort();
            switch (choice) {
                case 1:
                    System.out.println();
                    stockMenu();
                    mainMenu();
                    break;
                case 2:
                    patientMenu();
                    mainMenu();
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("ERROR: Choice not valid");
            }
        } while (choice < 0 || choice > 2);
    }

    public static void patientMenu(){
        System.out.println("---->  Patient Menu  <----");
        System.out.println("[1]- Add Vaccine");
        System.out.println("[2]- Display List");
        System.out.println("[3]- Update");
        System.out.println("[0]- Return to Main Menu");
        System.out.println("---------------");
        VaccineMangement vm = new VaccineMangement();
        vm.getAllVaccines();
        short choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Choice: ");

            choice = input.nextShort();
            switch (choice) {
                case 1:
                    System.out.println();
                    vm.addVaccine();
                    patientMenu();
                    break;
                case 2:
                    System.out.println();
                    vm.displayList();
                    patientMenu();
                    break;
                case 3:
                    System.out.println();
                    vm.update();
                    patientMenu();
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("ERROR: Choice not valid");
            }
        } while (choice < 0 || choice > 3);
    }

    public static void stockMenu() {
        System.out.println("---->  Stock Menu  <----");
        System.out.println("[1]- Add Vaccine Stock");
        System.out.println("[2]- Display Stock");
        System.out.println("[0]- Return to Main Menu");
        System.out.println("---------------");
        StockManagement sm = new StockManagement();
        sm.getAllStock();
        short choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Choice: ");

            choice = input.nextShort();
            switch (choice) {
                case 1:
                    System.out.println();
                    sm.addStock();
                    mainMenu();
                    break;
                case 2:
                    System.out.println();
                    sm.displayStock();
                    stockMenu();
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("ERROR: Choice not valid");
            }
        } while (choice < 0 || choice > 4);
    }
}







package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StockManagement {
    Scanner in = new Scanner(System.in);
    StockNode nv = new StockNode();

    public int pfizer;
    public int sinovec;
    public int sinopharm;

    public StockNode first;
    public StockNode last;


    public void update() {
        StockNode newNode = new StockNode();
        newNode.pfizer = nv.pfizer;
        newNode.sinopharm = nv.sinopharm;
        newNode.sinovec = nv.sinovec;


        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        this.last = newNode;

        String data = newNode.pfizer + "<->" + newNode.sinopharm + "<->" + newNode.sinovec + "\n";

        File file = new File("Stock.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void addVaccine() {
        try {
            nv.pfizer = Integer.toString(pfizer);
            nv.sinopharm = Integer.toString(sinopharm);
            nv.sinovec = Integer.toString(sinovec);

        } catch (Exception e) {
            System.out.println("An error occurred while converting the integer to a string.");
            e.printStackTrace();
        }
        System.out.println("Choose Vaccine:");
        System.out.println("[1]-Pfizer");
        System.out.println("[2]-Sinopharm");
        System.out.println("[3]-Sinovec");

        short choice = in.nextShort();
        switch (choice) {
            case 1:
                pfizer--;
                nv.pfizer = Integer.toString(pfizer);
                update();
                break;
            case 2:
                sinopharm--;
                nv.sinopharm = Integer.toString(sinopharm);
                update();
                break;
            case 3:
                sinovec--;
                nv.sinovec = Integer.toString(sinovec);
                update();
                break;

            default:
                System.out.println("ERROR: Choice not valid");
        }
    }

    public void getAllStock() {
        File file = new File("Stock.txt");
        try {
            Scanner reader = new Scanner(file);
            String line;
            String[] splited;

            while (reader.hasNext()) {
                line = reader.nextLine();
                splited = line.split("<->");
                StockNode newNode = new StockNode();
                newNode.pfizer = splited[0];
                newNode.sinopharm = splited[1];
                newNode.sinovec = splited[2];
                try {
                    pfizer = Integer.parseInt(newNode.pfizer);
                    sinopharm = Integer.parseInt(newNode.sinopharm);
                    sinovec = Integer.parseInt(newNode.sinovec);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: ");
                }
                if (first == null) {
                    first = newNode;
                } else {
                    last.next = newNode;
                    newNode.previous = last;
                }
                this.last = newNode;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !");
        }

    }

    public  void addStock(){
        try {
            nv.pfizer = Integer.toString(pfizer);
            nv.sinopharm = Integer.toString(sinopharm);
            nv.sinovec = Integer.toString(sinovec);

        } catch (Exception e) {
            System.out.println("An error occurred while converting the integer to a string.");
            e.printStackTrace();
        }
        System.out.println("Which Stock you want to update:");
        System.out.println("[1]-Pfizer");
        System.out.println("[2]-Sinopharm");
        System.out.println("[3]-Sinovec");

        int amount;
        short choice = in.nextShort();
        switch (choice) {
            case 1:
                System.out.println("Enter the amount you want to add");
                amount = in.nextInt();
                pfizer = pfizer + amount;
                nv.pfizer = Integer.toString(pfizer);
                update();
                break;
            case 2:
                System.out.println("Enter the amount you want to add");
                amount = in.nextInt();
                sinopharm = sinopharm+amount;
                nv.sinopharm = Integer.toString(sinopharm);
                update();
                break;
            case 3:
                System.out.println("Enter the amount you want to add");
                amount = in.nextInt();
                sinovec = sinovec + amount;
                nv.sinovec = Integer.toString(sinovec);
                update();
                break;

            default:
                System.out.println("ERROR: Choice not valid");
        }
    }

    public void displayStock() {
        last.displayNode();
        System.out.println();
    }

}

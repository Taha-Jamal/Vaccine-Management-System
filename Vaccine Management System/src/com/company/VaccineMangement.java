package com.company;

import java.io.*;

import java.util.Scanner;

public class VaccineMangement {
    Scanner in = new Scanner(System.in);
    StockManagement sm = new StockManagement();

    private NodeVaccine first;
    private NodeVaccine last;

    public VaccineMangement() {
        this.first = null;
        this.last = null;
    }

    public void addVaccine() {
        sm.getAllStock();
        System.out.println("Enter Patient Name:");
        String patientName = in.nextLine();

        in = new Scanner(System.in);    //Clearing Input Buffer

        System.out.println("Enter No of dose:");
        String numberofDose = in.nextLine();

        in = new Scanner(System.in);    //Clearing Input Buffer

        System.out.println("Age:");
        String age = in.nextLine();

        in = new Scanner(System.in);    //Clearing Input Buffer

        System.out.println("gender:");
        String gender = in.nextLine();

        in = new Scanner(System.in);    //Clearing Input Buffer

        System.out.println("Enter CNIC Number:");
        String cnic = in.nextLine();

        if (cnicCheck(cnic)) {
            sm.addVaccine(); //Asking for Vaccine type

            in = new Scanner(System.in);    //Clearing Input Buffer

            NodeVaccine newNode = new NodeVaccine();
            newNode.patientName = patientName;
            newNode.numberOfDose = numberofDose;
            newNode.age = age;
            newNode.gender = gender;
            newNode.cnic = cnic;
            if (first == null) {
                first = newNode;
            } else {
                last.next = newNode;
                newNode.previous = last;
            }
            this.last = newNode;

            String data = patientName + "<->" + numberofDose + "<->" + age + "<->" + gender + "<->" + cnic + "\n";

            File file = new File("Vaccine.txt");
            FileWriter writer = null;
            try {
                writer = new FileWriter(file, true);
                writer.write(data);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
    public boolean cnicCheck(String Cnic) {
        NodeVaccine current = first;
        while (current != null) {
            if (Cnic.equals(current.cnic)) {
                System.out.println("CNIC already exists in the list");
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public void displayList(){
        NodeVaccine current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public void getAllVaccines() {
        File file = new File("Vaccine.txt");
        try {
            Scanner reader = new Scanner(file);
            String line;
            String[] splited;

            while (reader.hasNext()) {
                line = reader.nextLine();
                splited = line.split("<->");
                NodeVaccine newNode = new NodeVaccine();
                newNode.patientName = splited[0];
                newNode.numberOfDose = splited[1];
                newNode.age = splited[2];
                newNode.gender = splited[3];
                newNode.cnic = splited[4];
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
    public void update() {
        Scanner input = new Scanner(System.in);
        String cnic;

        System.out.println("Enter CNIC:");
        cnic = input.nextLine();

        in = new Scanner(System.in);    //Clearing Input Buffer

        int flag = 0;
        NodeVaccine current = first;

        while (current != null && flag == 0) {
            if (cnic.equals(current.cnic))  {
                System.out.println("Enter Patient Name:");
                String patientName = in.nextLine();

                in = new Scanner(System.in);    //Clearing Input Buffer

                System.out.println("Enter No of does:");
                String numberofDose = in.nextLine();

                in = new Scanner(System.in);    //Clearing Input Buffer

                System.out.println("Age:");
                String age = in.nextLine();

                in = new Scanner(System.in);    //Clearing Input Buffer

                System.out.println("gender:");
                String gender = in.nextLine();

                in = new Scanner(System.in);    //Clearing Input Buffer

                System.out.println("Enter CNIC Number:");
                cnic = in.nextLine();

                in = new Scanner(System.in);    //Clearing Input Buffer

                //NodeVaccine newNode = new NodeVaccine();
                current.patientName = patientName;
                current.numberOfDose = numberofDose;
                current.age = age;
                current.gender = gender;
                current.cnic = cnic;
                flag=1;
            }
            current = current.next;
        }
        if(flag==0) {
            System.out.println("Data does not exist!");
        }
        else{
            PrintWriter riter = null;
            try {
                riter = new PrintWriter("Vaccine.txt");
                riter.print("");
                riter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            NodeVaccine c = first;
            while (c != null) {
                String data = c.patientName + "<->" + c.numberOfDose + "<->" + c.age + "<->" + c.gender + "<->" + c.cnic + "\n";

                File file = new File("Vaccine.txt");
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file, true);
                    writer.write(data);
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                c = c.next;
            }
        }
    }
}
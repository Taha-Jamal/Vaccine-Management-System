package com.company;

public class NodeVaccine {
    public String patientName;
    public String numberOfDose;

    public String age;
    public String gender;
    public String cnic;
    public NodeVaccine next;
    public NodeVaccine previous;

    public void displayNode() {
        System.out.print("[Patient Name: " + patientName + "]--");
        System.out.print("[Dose Number: " + numberOfDose + "]--");
        System.out.print("[Age: " + age + "]--");
        System.out.print("[Gender: " + gender + "]--");
        System.out.print("[CNIC: " + cnic + "]");
        System.out.println();
    }
}
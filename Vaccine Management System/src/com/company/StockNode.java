package com.company;

public class StockNode {
    public String pfizer;
    public String sinovec;
    public String sinopharm;
    public StockNode next;
    public StockNode previous;

    public void displayNode(){
        System.out.println("[Pfizer: "+pfizer+"]");
        System.out.println("[Sinopharm: "+sinopharm+"]");
        System.out.println("[Sinovec: "+sinovec+"]");

    }

}

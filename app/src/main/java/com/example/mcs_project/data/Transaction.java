package com.example.mcs_project.data;

public class Transaction {

    public static String transDate, medsName;
    public static int price, qty, img;

    public Transaction(String medsName, String transDate, int price, int qty, int img) {
        this.medsName = medsName;
        this.transDate = transDate;
        this.price = price;
        this.qty = qty;
        this.img = img;
    }
}

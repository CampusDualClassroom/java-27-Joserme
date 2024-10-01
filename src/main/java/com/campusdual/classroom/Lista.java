package com.campusdual.classroom;

public class Lista {
    public String quantity;
    public String text;

    public Lista(String quantity, String text) {
        this.quantity = quantity;
        this.text = text;
    }
    public Lista(){

    }

    @Override
    public String toString() {
        return "Items{" +
                "quantity='" + quantity + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

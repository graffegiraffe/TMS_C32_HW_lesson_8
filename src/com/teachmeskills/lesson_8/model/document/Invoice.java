package com.teachmeskills.lesson_8.model.document;

// TODO добавить поля на свое усмотрение
public class Invoice {

    private String id;
    private double amount;
    private String description;
    private String client;

    public Invoice(String id, double amount, String description, String client) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.client = client;
    }
}

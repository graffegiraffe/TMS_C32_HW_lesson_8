package com.teachmeskills.lesson_8.model.document;

import java.util.Date;

// TODO добавить поля: сумма перевода, дата перевода, номер счета или номер карты
// TODO создать метод для вывода информации о чеке на экран
public class Check {

    private double transferAmount;
    private Date transferDate;
    private String cardNumber;

    public Check(double transferAmount, Date transferDate, String cardNumber) {
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.cardNumber = cardNumber;
    }

    private String maskCardNumber(String cardNumber) {  //загуглила как сделать эту фичу, просто интересно было
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }

    public void printCheckInfo(){
        System.out.println("---check---");
        System.out.println("transfer amount:" + transferAmount);
        System.out.println("date of translation: " + transferDate);
        System.out.println("Номер карты: " + maskCardNumber(cardNumber));
        System.out.println("------------");
    }
}

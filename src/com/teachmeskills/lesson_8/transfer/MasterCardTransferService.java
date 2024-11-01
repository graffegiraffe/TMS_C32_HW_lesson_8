package com.teachmeskills.lesson_8.transfer.impl;

import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import java.util.Date;

// TODO реализовать имплементацию интерфейса
 public class MasterCardTransferService implements CardTransferService  {

    @Override
    public Check transferFromCardToCard(BaseCard fromCard, BaseCard toCard, double amount) {

        if (amount <= 0) {
            System.out.println("transfer amount must be greater than zero");
            return new Check(0, new Date(), fromCard.cardNumber);
        }

        if (!fromCard.checkCardLimitTransfer(amount)) {
            System.out.println("transfer exceeds card limit");
            return new Check(amount, new Date(), fromCard.cardNumber);
        }

        if (fromCard.amount < amount) {
            System.out.println("not enough funds on the card");
            return new Check(amount, new Date(), fromCard.cardNumber);
        }

        fromCard.amount -= amount;
        toCard.amount += amount;

        System.out.println("translation done by:");
        fromCard.showBaseInfo();
        toCard.showBaseInfo();

        return new Check(amount, new Date(), fromCard.cardNumber);
    }

    @Override
    public Check transferFromCardToAccount(BaseCard fromCard, String toAccount, double amount) {

        if (amount <= 0) {
            System.out.println("transfer amount must be greater than zero");
            return new Check(0, new Date(), fromCard.cardNumber);
        }

        if (!fromCard.checkCardLimitTransfer(amount)) {
            System.out.println("transfer exceeds card limit");
            return new Check(amount, new Date(), fromCard.cardNumber);
        }

        if (fromCard.amount < amount) {
            System.out.println("not enough funds on the card");
            return new Check(amount, new Date(), fromCard.cardNumber);
        }

        fromCard.amount -= amount;
        System.out.println("transfer to account completed:");
        fromCard.showBaseInfo();

        return new Check(amount, new Date(), fromCard.cardNumber);
    }
}

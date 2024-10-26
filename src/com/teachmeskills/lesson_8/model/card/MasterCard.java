package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.utils.Constants;
import java.util.Date;

public class MasterCard extends BaseCard {

    public String country;
    public MasterCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency, String country) {
        super(cardNumber, cvv, validDate, cardHolder, currency);
        this.country = country;
    }

    // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит
    @Override
    public boolean checkCardLimitTransfer(double transferAmount) {
        return transferAmount <= Constants.MASTER_CARD_LIMIT;
    }
}

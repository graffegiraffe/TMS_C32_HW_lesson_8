package com.teachmeskills.lesson_8.model.card;

import com.teachmeskills.lesson_8.utils.Constants;
import java.util.Date;

public class VisaCard extends BaseCard{

    public int cashback;
    public VisaCard(String cardNumber, int cvv, Date validDate, String cardHolder, String currency) {
        super(cardNumber, cvv, validDate, cardHolder, currency);
        this.cashback = cashback;
    }
    // TODO реализовать проверку лимита. суть проверки в том, что сумма для перевода не превышает лимит
    @Override
    public boolean checkCardLimitTransfer(double transferAmount) {
        return transferAmount <= Constants.VISA_CARD_LIMIT;
    }
}

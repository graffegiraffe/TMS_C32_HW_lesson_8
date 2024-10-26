package com.teachmeskills.lesson_8;

import com.teachmeskills.lesson_8.document_parser.IParser;
import com.teachmeskills.lesson_8.fabric.ParserFabric;
import com.teachmeskills.lesson_8.model.card.MasterCard;
import com.teachmeskills.lesson_8.model.client.*;
import com.teachmeskills.lesson_8.model.document.Check;
import com.teachmeskills.lesson_8.model.card.BaseCard;
import com.teachmeskills.lesson_8.model.card.VisaCard;
import com.teachmeskills.lesson_8.transfer.CardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.MasterCardTransferService;
import com.teachmeskills.lesson_8.transfer.impl.VisaCardTransferService;
import java.util.Date;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        // TODO запросить с консоли путь и имя файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the path and file name: ");
        String filePath = scanner.nextLine();
        
        // TODO сделать метод createParser статичным и избавиться от необходимости создания объекта parserFabric
        IParser parser = ParserFabric.createParser(filePath);
        parser.parseFile(filePath);
        // TODO заменить "" на имя файла, полученное со сканера


        // TODO реализовать тестовый сценарий
        // создать двух клиентов
        IndividualClient client1 = new IndividualClient();
        client1.name = "Alice";
        client1.passportNumber = "AA123456";

        LegalClient client2 = new LegalClient();
        client2.legalClientNumber = "LC654321";
        
        // каждому клиенту создать два счета и две карты
        BaseCard card1 = new MasterCard("1111222233334444", 123, new Date(), "Andrey", "USD","BLR");
        BaseCard card2 = new MasterCard("4444333322221111", 456, new Date(), "Andrey", "EUR","BLR");
        BaseCard card3 = new VisaCard("5555666677778888", 789, new Date(), "Kate", "USD");
        BaseCard card4 = new VisaCard("8888777766665555", 101, new Date(), "Kate", "EUR");

        client1.cards = new BaseCard[]{card1, card2};
        client2.cards = new BaseCard[]{card3, card4};

        card1.amount = 2000.00;
        card3.amount = 500.00;
        
        // перевести с карты одного клиента на карту другого сумму денег
        CardTransferService transferServiceVisa = new VisaCardTransferService();
        CardTransferService transferServiceMaster = new MasterCardTransferService();

        Check check1 = transferServiceMaster.transferFromCardToCard(card1, card3, 50.00);
        check1.printCheckInfo();
        // перевести с карты одного клинента на счет другого клиента сумму денег
        Check check2 = transferServiceVisa.transferFromCardToAccount(card1, "Kate_Account", 100.00);
        check2.printCheckInfo();
        //не сработае, лимит превышен
        Check check3 = transferServiceVisa.transferFromCardToAccount(card1, "Kate_Account", 9999.00);
        check3.printCheckInfo();
    }
}

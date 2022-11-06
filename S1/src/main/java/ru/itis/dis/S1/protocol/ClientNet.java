package ru.itis.dis.S1.protocol;

import ru.itis.dis.lab03.model.Bank;
import ru.itis.dis.lab03.model.Client;
import ru.itis.dis.lab03.model.Transaction;
import ru.itis.dis.lab03.service.XMLBankService;

import javax.xml.bind.JAXB;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class ClientNet {

    public static void main(String[] args) {
        try {
            String message = "Перевод 1000 рублей в банк";
            Scanner scanner = new Scanner(System.in);

            int len = message.getBytes("UTF-8").length;

            byte[] lenArray = toBytes(len);

            Socket clientSocket = new Socket ("localhost",50001);

            OutputStream os = clientSocket.getOutputStream();

            Client client1 = new Client();
            Transaction transaction = new Transaction();
            System.out.println("Имя");
            client1.setName(scanner.nextLine());
            System.out.println("Пасспорт");
            client1.setPassport(scanner.nextLine());
            System.out.println("sum");
            transaction.setSumm(Integer.parseInt(scanner.nextLine()));
            transaction.setClient(client1);
            transaction.setDate(new Date());

            //XMLBankService.convertClassToXML(transaction1, "hossamTransaction.xml");
            JAXB.marshal(transaction, os);

            clientSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] toBytes(int i) {

        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }

}

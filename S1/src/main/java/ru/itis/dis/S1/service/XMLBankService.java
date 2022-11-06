package ru.itis.dis.S1.service;

import ru.itis.dis.S1.model.Bank;
import ru.itis.dis.S1.model.Transaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class XMLBankService {

    public static void convertClassToXML(Transaction transaction, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

           marshaller.marshal(transaction, new File(fileName));
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
    }
    public static Bank convertXMLToClass(String fileName) {
        Bank bank2 = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            bank2 = (Bank) un.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return bank2;
    }
    public static Transaction fromXML(String xml) throws JAXBException, UnsupportedEncodingException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        return (Transaction) context.createUnmarshaller().unmarshal(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    }

}

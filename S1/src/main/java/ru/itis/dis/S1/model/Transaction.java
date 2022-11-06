package ru.itis.dis.S1.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class Transaction {

    Client client;
    String bankName;
    int summ;
    Date date;

    public Transaction(Client client, Bank bank, int summ, Date date) {
        this.client = client;
        this.bankName = bank.getName();
        this.summ = summ;
        this.date = date;
    }

    public Transaction(){

    }
    public Client getClient() {
        return client;
    }

    @XmlElement
    public void setClient(Client client) {
        this.client = client;
    }

    public String getBankName() {
        return bankName;
    }
    @XmlElement
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public int getSumm() {
        return summ;
    }
    @XmlElement
    public void setSumm(int summ) {
        this.summ = summ;
    }

    public Date getDate() {
        return date;
    }
    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "client=" + client +
                ", bankName='" + bankName + '\'' +
                ", summ=" + summ +
                ", date=" + date +
                '}';
    }
}

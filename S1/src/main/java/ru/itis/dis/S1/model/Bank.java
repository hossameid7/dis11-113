package ru.itis.dis.S1.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Bank {
    private String name;

    private List<Client> client;

    public Bank(String name, List<Client> client) {
        this.name = name;
        this.client = client;
    }

    public Bank() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "clients")
    @XmlElement(name = "client")
    public List<Client> getClients() {
        return client;
    }

    public void setClients(List<Client> clients) {
        this.client = clients;
    }
}

package ru.itis.dis.S1.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement
public class AcountInfo {
    String acountNumber;
    String summ;
    Date date;

    public AcountInfo(String acountNumber, String summ, Date date) {
        this.acountNumber = acountNumber;
        this.summ = summ;
        this.date = date;
    }

    public String getAcountNumber() {
        return acountNumber;
    }
    @XmlElement
    public void setAcountNumber(String acountNumber) {
        this.acountNumber = acountNumber;
    }

    public String getSumm() {
        return summ;
    }
    @XmlElement
    public void setSumm(String summ) {
        this.summ = summ;
    }

    public Date getDate() {
        return date;
    }
    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }
}

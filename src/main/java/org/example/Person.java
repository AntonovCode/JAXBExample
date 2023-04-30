package org.example;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "lastname", "firstname", "phones", "addresses"})
public class Person {
    @XmlElement
    private String firstname;

    @XmlElement
    private String lastname;

    @XmlTransient
    private String secondName;

    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phoneInfo")
    private ArrayList<PhoneInfo> phones;

    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    private ArrayList<String> addresses;

    public Person() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public ArrayList<PhoneInfo> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<PhoneInfo> phones) {
        this.phones = phones;
    }

    public ArrayList<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<String> addresses) {
        this.addresses = addresses;
    }
}

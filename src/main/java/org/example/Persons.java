package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Persons {
    private ArrayList<Person> persons;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    @XmlElement(name = "person")
    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
}

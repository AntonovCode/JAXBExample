package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.stream.Collectors;

public class XmlToJava {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Persons persons = (Persons) unmarshaller.unmarshal(new File("output.xml"));

        persons.getPersons().stream().forEach(person -> {
            System.out.println(person.getLastname() + " " + person.getFirstname());

            String phones = person.getPhones().stream()
                    .map(phoneInfo -> phoneInfo.toString())
                    .collect(Collectors.joining(", "));

            System.out.println("Телефоны: " + phones);
            System.out.println("Адреса:");
            person.getAddresses().stream().forEach(System.out::println);
            System.out.println();
        });
    }
}

package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;

public class JavaToXml {
    public static void main(String[] args) throws JAXBException {
        ArrayList<PhoneInfo> list1 = new ArrayList<>();
        list1.add(new PhoneInfo("8-800-000-00-00", true));
        list1.add(new PhoneInfo("8-800-000-00-01", false));
        list1.add(new PhoneInfo("8-800-000-00-02", false));
        list1.add(new PhoneInfo("8-800-000-00-03", false));
        list1.add(new PhoneInfo("8-800-000-00-04", false));

        ArrayList<String> addresses1 = new ArrayList<>();
        addresses1.add("Тамбовская область, город Дмитров, бульвар Славы, 70");
        addresses1.add("Самарская область, город Подольск, пр. Ладыгина, 50");
        addresses1.add("Читинская область, город Коломна, бульвар Космонавтов, 34");

        var person1 = new Person();
        person1.setLastname("Иванов");
        person1.setFirstname("Иван");
        person1.setSecondName("Иванович");
        person1.setPhones(list1);
        person1.setAddresses(addresses1);

        ArrayList<PhoneInfo> lis2 = new ArrayList<>();
        lis2.add(new PhoneInfo("8-800-777-00-00", true));
        lis2.add(new PhoneInfo("8-800-777-00-01", false));
        lis2.add(new PhoneInfo("8-800-777-00-02", false));
        lis2.add(new PhoneInfo("8-800-777-00-03", false));
        lis2.add(new PhoneInfo("8-800-777-00-04", false));

        ArrayList<String> addresses2 = new ArrayList<>();
        addresses2.add("Псковская область, город Серпухов, ул. Ленина, 51");
        addresses2.add("Самарская область, город Можайск, пл. Гоголя, 65");

        var person2 = new Person();
        person2.setLastname("Петров");
        person2.setFirstname("Сергей");
        person2.setSecondName("Александрович");
        person2.setPhones(lis2);
        person2.setAddresses(addresses2);

        Persons persons = new Persons();
        persons.setPersons(new ArrayList<>());
        persons.getPersons().add(person1);
        persons.getPersons().add(person2);

        JAXBContext context = JAXBContext.newInstance(Persons.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(persons, System.out);

        File file = new File("output.xml");
        marshaller.marshal(persons, file);
    }
}
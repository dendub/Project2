import Entity.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.hibernate.Query;
import persistence.*;
import org.hibernate.Session;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        // fillwithvalues();
        //  dbtojson();
        jsontodb();
         dbtoxml();

//        xmltodb();
        //     showqrs();



    }

    public static void fillwithvalues() { //заполняет базу

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Phone phone = new Phone();
        phone.setCompany("Apple");
        phone.setModel("Xs");
        phone.setCountry("USA");

        Phone phone2 = new Phone();
        phone2.setCompany("Samsung");
        phone2.setModel("Galaxy note 8");
        phone2.setCountry("Korea");

        Characteristics charac = new Characteristics();
        charac.setPhone(phone);
        charac.setBody("notch");
        charac.setColor("white");
        charac.setScreen_size(6);

        Characteristics charac2 = new Characteristics();
        charac2.setPhone(phone2);
        charac2.setBody("borderless");
        charac2.setColor("red");
        charac2.setScreen_size(5);

        Company comp = new Company();
        comp.setPhone(phone);
        comp.setName("Apple California");

        Company comp2 = new Company();
        comp2.setPhone(phone);
        comp2.setName("Apple Chicago");

        Company comp3 = new Company();
        comp3.setPhone(phone2);
        comp3.setName("Samsung Seoul");

        Company comp4 = new Company();
        comp4.setPhone(phone2);
        comp4.setName("Samsung Basan");

        Clients clien = new Clients();
        clien.setPhone(phone);
        clien.setCity("Dakar");
        clien.setAmount(2);
        clien.setComments("asap");

        Clients clien2 = new Clients();
        clien2.setPhone(phone2);
        clien2.setCity("London");
        clien2.setAmount(3);
        clien2.setComments("until spring");


        Delivery delivery = new Delivery();
        delivery.setClients(clien);
        delivery.setType("plane");

        Delivery delivery2 = new Delivery();
        delivery2.setClients(clien2);
        delivery2.setType("ship");

        session.save(phone);
        session.save(phone2);
        session.save(charac);
        session.save(charac2);
        session.save(comp);
        session.save(comp2);
        session.save(comp3);
        session.save(comp4);
        session.save(clien);
        session.save(clien2);
        session.save(delivery);
        session.save(delivery2);


        session.getTransaction().commit();
    }
    public static void dbtojson() { //запись из базы в джейсон

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT k FROM Phone k");
        List<Phone> phn = query.list();
        query = session.createQuery("SELECT k FROM Characteristics k");
        List<Characteristics> chara = query.list();
        query = session.createQuery("SELECT k FROM Clients k");
        List<Clients> cli = query.list();
        query = session.createQuery("SELECT k FROM Company k");
        List<Company> com = query.list();
        query = session.createQuery("SELECT k FROM Delivery k");
        List<Delivery> deliver = query.list();


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/characteristics.json"), chara);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/delivery.json"), deliver);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/company.json"), com);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/clients.json"), cli);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/phone.json"), phn);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void dbtoxml() { // из базы в иксмэль

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT k FROM Phone k");
        List<Phone> phn = query.list();
        query = session.createQuery("SELECT k FROM Characteristics k");
        List<Characteristics> chara = query.list();
        query = session.createQuery("SELECT k FROM Clients k");
        List<Clients> cli = query.list();
        query = session.createQuery("SELECT k FROM Company k");
        List<Company> com = query.list();
        query = session.createQuery("SELECT k FROM Delivery k");
        List<Delivery> deliver = query.list();


        ObjectMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/characteristics.xml"), chara);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/delivery.xml"), deliver);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/company.xml"), com);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/clients.xml"), cli);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("target/phone.xml"), phn);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void jsontodb(){ // из джейсона в бау
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Phone> phn = objectMapper.readValue(new File("target/phone1.json"), new TypeReference<List<Phone>>(){});
            List<Characteristics> chara = objectMapper.readValue(new File("target/characteristics1.json"), new TypeReference<List<Characteristics>>(){});
            List<Delivery> deliver = objectMapper.readValue(new File("target/delivery1.json"), new TypeReference<List<Delivery>>(){});
            List<Company> com = objectMapper.readValue(new File("target/company1.json"), new TypeReference<List<Company>>(){});
            List<Clients> cli = objectMapper.readValue(new File("target/clients1.json"), new TypeReference<List<Clients>>(){});

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            for (Characteristics t: chara) {
                session.save(t);
            }
            for (Clients t: cli) {
                session.save(t);
            }
            for (Company t: com) {
                session.save(t);
            }
            for (Delivery t: deliver) {
                session.save(t);
            }
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void xmltodb(){ // из эксэмэля
        ObjectMapper xmlMapper = new XmlMapper();
        try {
            List<Phone> phn = xmlMapper.readValue(new File("target/phone1.xml"), new TypeReference<List<Phone>>(){});
            List<Characteristics> chara = xmlMapper.readValue(new File("target/characteristics1.xml"), new TypeReference<List<Characteristics>>(){});
            List<Delivery> deliver = xmlMapper.readValue(new File("target/delivery1.xml"), new TypeReference<List<Delivery>>(){});
            List<Company> com = xmlMapper.readValue(new File("target/company1.xml"), new TypeReference<List<Company>>(){});
            List<Clients> cli = xmlMapper.readValue(new File("target/clients1.xml"), new TypeReference<List<Clients>>(){});

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            for (Characteristics t: chara) {
                session.save(t);
            }
            for (Clients t: cli) {
                session.save(t);
            }
            for (Company t: com) {
                session.save(t);
            }
            for (Delivery t: deliver) {
                session.save(t);
            }
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void showqrs(){ // квесрис
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT k FROM Phone k");
        List<Phone> phn = query.list();
        System.out.println(phn);
        query = session.createQuery("SELECT color FROM Characteristics");
        List<Characteristics> chara = query.list();
        System.out.println(chara);
        query = session.createQuery("SELECT amount FROM Clients");
        List<Clients> cli = query.list();
        System.out.println(cli);
        query = session.createQuery("SELECT k FROM Company k");
        int pageNumber = 1;
        int pageSize = 2;
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        List<Company> com = query.list();
        for (Company comp: com){
            System.out.println(comp.getName());
        }
//        System.out.println(carcreat);
        query = session.createQuery("SELECT type FROM Delivery");
        List<Delivery> deliver = query.list();
        System.out.println(deliver);
    }

}
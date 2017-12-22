package com.sidgs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File fs = new File("C:\\Users\\annam\\IdeaProjects\\hibernatecase\\src\\main\\java\\com\\sidgs\\hibernate.cfg.xml");
        SessionFactory  factory = new Configuration().configure(fs).buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Species s = new Species();
        s.setSpec_id(1);
        s.setSpec_type("Animals");
        s.setSpec_status("Partial");
        Animals a = new Animals();
        a.setAnimal_name("Tiger");
        a.setAnimal_type("Mammal");
        session.save(a);
        s.setAnimals(a);
        session.save(s);

        session.getTransaction().commit();
        System.out.println("Transaction Added");
        session.close();
    }
}

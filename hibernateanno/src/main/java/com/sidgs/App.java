package com.sidgs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File fs = new File("C:\\Users\\annam\\IdeaProjects\\hibernateanno\\src\\main\\java\\com\\sidgs\\hibernate.cfg.xml");
        SessionFactory factory = new Configuration().configure(fs).buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Animal a = new Animal();
        a.setAnimal_id(5);
        a.setAnimal_Name("Lion");
        a.setGender("Male");
        a.setDob(new Date());
        session.save(a);
        session.getTransaction().commit();
        System.out.println("Transaction is added");
        session.close();
    }
}

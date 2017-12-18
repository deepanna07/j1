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
        File fs = new File("C:\\Users\\annam\\IdeaProjects\\Hibernateembeded\\src\\main\\java\\com\\sidgs\\hibernate.cf.xml");
        SessionFactory factory = new Configuration().configure(fs).buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Employee e = new Employee();
        e.setEmp_id(1);
        e.setEmp_name("Dave");
        Address address = new Address();
        address.setStreet("63 Atherton DR");
        address.setCity("Exton");
        address.setState("PA");
        address.setPin_code(19341);
        e.setAddress(address);
        session.save(e);
        session.getTransaction().commit();
        System.out.println("Transaction Added");
        session.close();
    }
}

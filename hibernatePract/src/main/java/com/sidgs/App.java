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
        File fs=new File("C:\\Users\\annam\\IdeaProjects\\hibernatePract\\src\\main\\java\\com\\sidgs\\hibernate.cfg.xml");

        SessionFactory sessionFactory=new Configuration().configure(fs).buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Book book=new Book();
        book.setId(1);
        book.setBookName("Tree Life");
        session.save(book);
        session.getTransaction().commit();
        session.close();
        System.out.println("Tree added");
    }
}

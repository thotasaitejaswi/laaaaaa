package com.hibernate.Crud_operations;

import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        //create and insert data
    /*	Alien tel=new Alien();
    	tel.setColor("orange");
    	tel.setId(32);
    	tel.setName("kavya"); */
    	
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf=con.buildSessionFactory();
        
        Session session=sf.openSession();
        
        Transaction tx=session.beginTransaction();
        
    //    session.save(tel);  //insert data
       
       // retrive the  data
       Alien s=session.get(Alien.class,78); 
         System.out.println("Id : "+s.getId()); 
        System.out.println("Name : "+s.getName()); 
        System.out.println("Class : "+s.getColor()); 
        
       //update the data
        Alien s1=session.get(Alien.class,45);
        s1.setColor("pink");
        System.out.println("Updated Successfully");
        session.save(s1);

        // Delete the record
        session.delete(s1);

        
        tx.commit();
        session.close();
        sf.close();
    }
}

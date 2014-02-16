package com.wichf;

import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManagePatient {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManagePatient ME = new ManagePatient();
      ME.listEmployees();
   }
      public void listEmployees( ){
          Session session = factory.openSession();
          Transaction tx = null;
          try{
             tx = session.beginTransaction();
             List employees = session.createQuery("FROM patient").list(); 
             for (Iterator iterator = 
                               employees.iterator(); iterator.hasNext();){
                Patient employee = (Patient) iterator.next(); 
                System.out.print("First Name: " + employee.getName()); 
                System.out.print("  ID: " + employee.getId()); 
               
             }
             tx.commit();
          }catch (HibernateException e) {
             if (tx!=null) tx.rollback();
             e.printStackTrace(); 
          }finally {
             session.close(); 
          }
      
}
}

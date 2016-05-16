/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Entities.Person;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * @author Lehlogonolo
 */
public class PersonTest {
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Person. Retrieve an existing Person from the research database.
     */
    @Test
    public void testGet() {
        
         // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        System.out.println("PersonJUnitTest: Retrieve an existing person");
        String ng="";
        TypedQuery<Person> query= manager.createNamedQuery("Person.findByFirstname",Person.class);
        query.setParameter("firstname", "John"); 
        List results=query.getResultList();
         Person f1=(Person) results.get(0);
         String methodTestName= f1.getFirstname();
         String methodTestSurname= f1.getSurname();
         Integer methodTestID= f1.getId();
         String expectedResultName= "John";
         String expectedResultSurname="Tleane";
         Integer expectedResultID=100;
         assertEquals(expectedResultName, methodTestName );
         assertEquals(expectedResultSurname, methodTestSurname );
         assertEquals(expectedResultID, methodTestID );
        System.out.println("Person successfully retrieved");
    }

    /**
     * Test of set methods, of class Person. Add a new Person into research database.
     */
   @Test
    public void testSet() {
        System.out.println("PersonJUnitTest: Add a new person");
        
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Person instance = new Person();
        instance.setFirstname("Tony");
        instance.setSurname("Stark");
        instance.setId(1);
        
        TypedQuery<Person> query= manager.createNamedQuery("Person.findByFirstname",Person.class);
        query.setParameter("firstname", "Tony"); 
        List results=query.getResultList();
        Person f1=(Person) results.get(0);
        String expResultName= f1.getFirstname(); //If set has worked successfully, name retieved should be 'Tony'
        String expResultSurname= f1.getSurname();//If set has worked successfully, surname retieved should be 'Stark'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
       
       
        String Nameresult = instance.getFirstname();
        String Surnameresult= instance.getSurname();
        Integer idResult= instance.getId();
        
        assertEquals(expResultName, Nameresult);
        assertEquals(expResultSurname, Surnameresult);
        assertEquals(expResultID, idResult);
        System.out.println("Person successfully added");
        fail ("Test Failure: New person not added");
    }
}

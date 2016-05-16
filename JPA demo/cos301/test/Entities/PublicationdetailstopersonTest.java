/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lehlogonolo
 */
public class PublicationdetailstopersonTest {
    
    public PublicationdetailstopersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationdetailstoperson.
     */
    @Test
    public void testGetId() {
         System.out.println("Pubicationdetailstoperson JUnit Test: Get pub details per author");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); 
        EntityManager manager=factory.createEntityManager();
        TypedQuery<Publicationdetailstoperson> query= manager.createNamedQuery("Publicationdetailstoperson.findById",Publicationdetailstoperson.class);
        query.setParameter("id", 100);        
        List results=query.getResultList();
        Publicationdetailstoperson f1=(Publicationdetailstoperson) results.get(0); 
        
        //Publicationdetailstoperson instance = new Publicationdetailstoperson();
        Integer expResult = 100;
        Integer result = f1.getId();
        Integer expName= 100;
        Integer resultName= f1.getPerson();
        Integer expPub=100;
        Integer resultPub= f1.getPublicationdetails();
       
        assertEquals(expResult, result);
        assertEquals(expName, resultName);
        assertEquals(expPub, resultPub);
        System.out.println("Per Person Publication details successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationdetailstoperson.
     */
   @Test
     public void testSet() {
        
         System.out.println("PublicationdetailstopersonJUnitTest: Add a new per person publication details");
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Publicationdetailstoperson instance = new Publicationdetailstoperson();
        instance.setPerson(200);
        instance.setPublicationdetails(200);
        instance.setId(1);
        
        TypedQuery<Publicationdetailstoperson> query= manager.createNamedQuery("Publicationdetailstoperson.findById",Publicationdetailstoperson.class);
        query.setParameter("id", 1); 
        List results=query.getResultList();
        Publicationdetailstoperson f1=(Publicationdetailstoperson) results.get(0);
        Integer expResult1= f1.getPerson(); //If set has worked successfully, person retieved should be '200'
        Integer expResult2= f1.getPublicationdetails();//If set has worked successfully, pub details retieved should be '200'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
       
       
        Integer result1 = instance.getPerson();
        Integer result2= instance.getPublicationdetails();
        Integer idResult= instance.getId();
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationdetailstoperson successfully added");
        fail ("Test Failure: New per person details not added");
    }
}

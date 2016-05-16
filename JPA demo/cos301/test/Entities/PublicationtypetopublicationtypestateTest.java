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
public class PublicationtypetopublicationtypestateTest {
    
    public PublicationtypetopublicationtypestateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationtypetopublicationtypestate.
     */
    @Test
    public void testGetId() {
        System.out.println("PublicationtypetopublicationtypestateJUnitTest: Retrieve a Publicationtypetopublicationtypestate");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); 
        EntityManager manager=factory.createEntityManager();
        TypedQuery<Publicationtypetopublicationtypestate> query= manager.createNamedQuery("Publicationtypetopublicationtypestate.findById",Publicationtypetopublicationtypestate.class);
        query.setParameter("id",100);        
        List results=query.getResultList();
        Publicationtypetopublicationtypestate f1=(Publicationtypetopublicationtypestate) results.get(0); 
        
        //Publicationtypetopublicationtypestate instance = new Publicationtypetopublicationtypestate();
        Integer expResult = 100;
        Integer result = f1.getId();
        Integer expPubType= 100;
        Integer resultPubType= f1.getPublicationtype();
        Integer expPubState=100;
        Integer resultPubState= f1.getPublicationtypestate();
       
        assertEquals(expResult, result);
        assertEquals(expPubType, resultPubType);
        assertEquals(expPubState, resultPubState);
        System.out.println("Target successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationtypetopublicationtypestate.
     */
    @Test
       public void testSet() {
        
         System.out.println("PublicationtypetopublicationtypestateJUnitTest: Add a Publicationtypetopublicationtypestate ");
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Publicationtypetopublicationtypestate instance = new Publicationtypetopublicationtypestate();
        instance.setPublicationtype(200);
        instance.setPublicationtypestate(200);
        instance.setId(1);
        
        TypedQuery<Publicationtypetopublicationtypestate> query= manager.createNamedQuery("Publicationtypetopublicationtypestate.findById",Publicationtypetopublicationtypestate.class);
        query.setParameter("id", 1); 
        List results=query.getResultList();
        Publicationtypetopublicationtypestate f1=(Publicationtypetopublicationtypestate) results.get(0);
        Integer expResult1= f1.getPublicationtype(); //If set has worked successfully, pub type retieved should be '200'
        Integer expResult2= f1.getPublicationtypestate();//If set has worked successfully, pub type state retieved should be '200'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
       
       
        Integer result1 = instance.getPublicationtype();
        Integer result2= instance.getPublicationtypestate();
        Integer idResult= instance.getId();
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationtypetopublicationtypestate successfully added");
        fail ("Test Failure: Publicationtypetopublicationtypestate not added");
    }
    
}

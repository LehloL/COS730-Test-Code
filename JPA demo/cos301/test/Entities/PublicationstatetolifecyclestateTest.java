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
public class PublicationstatetolifecyclestateTest {
    
    public PublicationstatetolifecyclestateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationstatetolifecyclestate.
     */
    @Test
    public void testGetId() {
         System.out.println("Publicationstatetolifecyclestate JUnit Test");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); 
        EntityManager manager=factory.createEntityManager();
        TypedQuery<Publicationstatetolifecyclestate> query= manager.createNamedQuery("Publicationstatetolifecyclestate.findById",Publicationstatetolifecyclestate.class);
        query.setParameter("id", 100);        
        List results=query.getResultList();
        Publicationstatetolifecyclestate f1=(Publicationstatetolifecyclestate) results.get(0); 
        
        //Publicationstatetolifecyclestate instance = new Publicationstatetolifecyclestate();
        Integer expResult = 100;
        Integer result = f1.getId();
        Integer explife= 300;
        Integer resultlife= f1.getLifecyclestate();
        Integer expPub=100;
        Integer resultPub= f1.getPublicationstate();
       
        assertEquals(expResult, result);
        assertEquals(explife, resultlife);
        assertEquals(expPub, resultPub);
        System.out.println("Target successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationstatetolifecyclestate.
     */
    @Test
       public void testSet() {
        
         System.out.println("PublicationstatetolifecyclestateJUnitTest: Add a new per person publication details");
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Publicationstatetolifecyclestate instance = new Publicationstatetolifecyclestate();
        instance.setLifecyclestate(200);
        instance.setPublicationstate(200);
        instance.setId(1);
        
        TypedQuery<Publicationstatetolifecyclestate> query= manager.createNamedQuery("Publicationstatetolifecyclestate.findById",Publicationstatetolifecyclestate.class);
        query.setParameter("id", 1); 
        List results=query.getResultList();
        Publicationstatetolifecyclestate f1=(Publicationstatetolifecyclestate) results.get(0);
        Integer expResult1= f1.getLifecyclestate(); //If set has worked successfully, lifecycle state retieved should be '200'
        Integer expResult2= f1.getPublicationstate();//If set has worked successfully, pub state retieved should be '200'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
       
       
        Integer result1 = instance.getLifecyclestate();
        Integer result2= instance.getPublicationstate();
        Integer idResult= instance.getId();
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationstatetolifecyclestate successfully added");
        fail ("Test Failure: New Publicationstatetolifecyclestate not added");
    }
}

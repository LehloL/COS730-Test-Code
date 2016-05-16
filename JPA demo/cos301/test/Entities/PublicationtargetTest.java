/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import java.util.Vector; //try and fix get method
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moses
 */
public class PublicationtargetTest {
    
    public PublicationtargetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() 
    {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
      Test of getId method, of class Publicationtarget.
     */
    @Test
    public void testGetId() {
        System.out.println("PublicationtargetJUnitTest: Retrieve publication target details");
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); 
        EntityManager manager=factory.createEntityManager();
        TypedQuery<Publicationtarget> query= manager.createNamedQuery("Publicationtarget.findByWebsite",Publicationtarget.class);
        query.setParameter("website", "Google");        
        List results=query.getResultList();
        Publicationtarget f1=(Publicationtarget) results.get(0); 
        
        //Publicationtarget instance = new Publicationtarget();
        Integer expResult = 600;
        Integer result = f1.getId();
        String expName= "mcmillin";
        String resultName= f1.getName();
        String expSite="Google";
        String resultSite= f1.getWebsite();
       
        assertEquals(expResult, result);
        assertEquals(expName, resultName);
        assertEquals(expSite, resultSite);
        System.out.println("Publication Target successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationtarget.*/
     
    @Test
       public void testSet() {
        
         System.out.println("PublicationtargetJUnitTest: Add a new per person publication details");
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Publicationtarget instance = new Publicationtarget();
        instance.setName("name");
        instance.setWebsite("www.name.com");
        instance.setId(1);
        
        TypedQuery<Publicationtarget> query= manager.createNamedQuery("Publicationtarget.findById",Publicationtarget.class);
        query.setParameter("id", 1); 
        List results=query.getResultList();
        Publicationtarget f1=(Publicationtarget) results.get(0);
        String expResult1= f1.getName(); //If set has worked successfully, name retieved should be 'name'
        String expResult2= f1.getWebsite();//If set has worked successfully, website retieved should be 'www.name.com'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
       
       
        String result1 = instance.getName();
        String result2= instance.getWebsite();
        Integer idResult= instance.getId();
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationtarget successfully added");
        fail ("Test Failure: New Publicationtarget not added");
    }
    
}

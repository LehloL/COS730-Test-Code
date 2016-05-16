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
public class PublicationtypeTest {
    
    public PublicationtypeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationtype. Retrieve existing publication type
     */
    @Test
    public void testGet() {
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        System.out.println("PublicationtypeJUnitTest: Retrieve an existing publication type");
        TypedQuery<Publicationtype> query= manager.createNamedQuery("Publicationtype.findById",Publicationtype.class);
        query.setParameter("id", 2); 
        List results=query.getResultList();
         Publicationtype f1=(Publicationtype) results.get(0);
         String methodTestName= f1.getName();
         Integer methodTestID= f1.getId();
         String expectedResultName= "VIC_PAPERS";
         Integer expectedResultID=2;
         assertEquals(expectedResultName, methodTestName );
         assertEquals(expectedResultID, methodTestID );
        System.out.println("Publicationtype successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationtype.
     */
    @Test
       public void testSet() {
        
         System.out.println("PublicationtypeJUnitTest: Add a new publication type");
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
                     
        Publicationtype instance = new Publicationtype();
        instance.setName("name");
        instance.setId(1);
        
        TypedQuery<Publicationtype> query= manager.createNamedQuery("Publicationtype.findById",Publicationtype.class);
        query.setParameter("id", 1); 
        List results=query.getResultList();
        Publicationtype f1=(Publicationtype) results.get(0);
        String expResult1= f1.getName(); //If set has worked successfully, name retieved should be 'name'
        Integer expResultID= f1.getId();//If set has workeInteger expResult2= f1.getPublid successfully, id retrieved should be '1'
       
       
        String result1 = instance.getName();
        Integer idResult= instance.getId();
        
        assertEquals(expResult1, result1);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationtype successfully added");
        fail ("Test Failure: Publicationtype not added");
    }
    
}

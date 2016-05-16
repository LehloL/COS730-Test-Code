/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PublicationstateTest {
    
    public PublicationstateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationstate.
     */
    @Test
    public void testGetId() throws ParseException {
         // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        System.out.println("PublicationstateJUnitTest: Retrieve existing publication states");
        TypedQuery<Publicationstate> query= manager.createNamedQuery("Publicationstate.findById",Publicationstate.class);
        query.setParameter("id", 100); 
        List results=query.getResultList();
        Publicationstate f1=(Publicationstate) results.get(0);
         
        String methodTestReason= f1.getReason();
        Integer methodTestID= f1.getId();
        String expectedResultReason= "In Progress: Waiting on final experiment results";
        Integer expectedResultID=100;
        
        Date methodTestPubDate= f1.getDate();
        String resultDate= methodTestPubDate.toString();
        String expectedResultPubDate= "2016/03/01";
               
         //convert date format in order to be able to assert equality
         String OLD_FORMAT = "EEE MMM dd hh:mm:ss zzz yyyy";
         String NEW_FORMAT = "yyyy/MM/dd";
         
            String oldDateString = resultDate;
            String newDateString;

            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(oldDateString);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
         
        assertEquals(expectedResultReason, methodTestReason );
         assertEquals(expectedResultPubDate, newDateString );
         assertEquals(expectedResultID, methodTestID );
        System.out.println("Publicationstate successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationstate.
     */
    @Test
    public void testSetId() throws ParseException {
        System.out.println("PublicationstateJUnitTest: Add a new lifecyclestate");
        
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
            
        Publicationstate instance = new Publicationstate();
        instance.setReason("reason");
        instance.setId(1); 
        
        //extra work for date
        String testdate="01/01/2016";
        DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
        Date startDate= (Date)formatter.parse(testdate);
        instance.setDate(startDate);
       
        
        TypedQuery<Publicationstate> query= manager.createNamedQuery("Publicationstate.findById",Publicationstate.class);
        query.setParameter("id",1); 
        List results=query.getResultList();
        Publicationstate f1=(Publicationstate) results.get(0);
        
        String expResult1= f1.getReason(); //If set has worked successfully, reason retrieved should be 'reason'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
        Date expDate= f1.getDate();//1f set has worked successfully, date retrieved should be o1/o1/2016
                
        String result1 = instance.getReason();
        Integer idResult= instance.getId();
        Date result3= instance.getDate();
        
        //convert date format in order to be able to assert equality
         String OLD_FORMAT = "EEE MMM dd hh:mm:ss zzz yyyy";
         String NEW_FORMAT = "yyyy/MM/dd";
            String result3Date= result3.toString();
            String oldDateString = result3Date;
            String newDateString;

            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(oldDateString);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
         
         //check if methods work as expected
        assertEquals(expDate, newDateString);
        assertEquals(expResult1, result1);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationstate successfully added");
        fail ("Test Failure: New publication state not added");
    }

}

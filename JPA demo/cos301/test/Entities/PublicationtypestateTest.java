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
public class PublicationtypestateTest {
    
    public PublicationtypestateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationtypestate.
     */
    @Test
    public void testGetId() throws ParseException {
         // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        System.out.println("PublicationtypestateJUnitTest: Retrieve existing publication type state");
        TypedQuery<Publicationtypestate> query= manager.createNamedQuery("Publicationtypestate.findById",Publicationtypestate.class);
        query.setParameter("id", 100); 
        List results=query.getResultList();
        Publicationtypestate f1=(Publicationtypestate) results.get(0);
         
        String methodTestState= f1.getState();
        Integer methodTestID= f1.getId();
        String expectedResultState= "TestState";
        Integer expectedResultID=100;
        Float methodTestPoints= f1.getAccredationpoints();
        Float expectedPoints= 5.6f;
        String methodTestReason= f1.getDeactivationreason();
        String expectedReason="TestReason";
        
        Date methodTestPubDate= f1.getEffectivedate();
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
         
        assertEquals(expectedResultState, methodTestState );
         assertEquals(expectedResultPubDate, newDateString );
         assertEquals(expectedResultID, methodTestID );
         assertEquals(expectedPoints, methodTestPoints );
         assertEquals(expectedReason, methodTestReason );
        System.out.println("Publicationtypestate successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationtypestate.
     */
    @Test
     public void testSetId() throws ParseException {
        System.out.println("PublicationtypestateJUnitTest: Add a new lifecyclestate");
        
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
            
        Publicationtypestate instance = new Publicationtypestate();
        
        instance.setAccredationpoints(1.0f);
        instance.setDeactivationreason("deactivationreason");
        instance.setId(1); 
        instance.setState("state");
        
        //extra work for date
        String testdate="01/01/2016";
        DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
        Date startDate= (Date)formatter.parse(testdate);
        instance.setEffectivedate(startDate);
       
        
        TypedQuery<Publicationtypestate> query= manager.createNamedQuery("Publicationtypestate.findById",Publicationtypestate.class);
        query.setParameter("id",1); 
        List results=query.getResultList();
        Publicationtypestate f1=(Publicationtypestate) results.get(0);
        
        Float expResult1= f1.getAccredationpoints(); //If set has worked successfully, acc points retieved should be '1.0'
        String expResult2= f1.getDeactivationreason();//If set has worked successfully, deac. reason retieved should be deactivationreason
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
        Date expDate= f1.getEffectivedate();//1f set has worked successfully, date retrieved should be o1/o1/2016
                
        Float result1 = instance.getAccredationpoints(); 
        String result2= instance.getDeactivationreason();
        Integer idResult= instance.getId();
        Date result3= instance.getEffectivedate();
        
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
        assertEquals(expResult2, result2);
        assertEquals(expResultID, idResult);
        System.out.println("Publicationtypestate successfully added");
        fail ("Test Failure: New Publicationtypestate not added");
    }
}

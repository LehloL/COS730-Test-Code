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
public class PublicationdetailsTest {
    
    public PublicationdetailsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class Publicationdetails. Retrieve publication from the database
     */
    @Test
    public void testGetId() throws ParseException {
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        System.out.println("PublicationdetailsJUnitTest: Retrieve existing publication details");
        TypedQuery<Publicationdetails> query= manager.createNamedQuery("Publicationdetails.findById",Publicationdetails.class);
        query.setParameter("id", 100); 
        List results=query.getResultList();
        Publicationdetails f1=(Publicationdetails) results.get(0);
         
        String methodTestTitle= f1.getTitle();
        Integer methodTestID= f1.getId();
        String expectedResultTitle= "TestPaper";
        Integer expectedResultID=100;
        
        Date methodTestPubDate= f1.getEnvisagedpublicationdate();
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
         
        assertEquals(expectedResultTitle, methodTestTitle );
         assertEquals(expectedResultPubDate, newDateString );
         assertEquals(expectedResultID, methodTestID );
        System.out.println("Publicationdetails successfully retrieved");
    }

    /**
     * Test of setId method, of class Publicationdetails. Add a publication to the database
     */
    @Test
     public void testSetId() throws ParseException {
        System.out.println("PublicationdetailsJUnitTest: Add  new publication details");
        
          // TODO code application logic here
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
            
        Publicationdetails instance = new Publicationdetails();
        
        instance.setTitle("title");
        instance.setId(1); 
        
        //extra work for date
        String testdate="01/01/2016";
        DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
        Date startDate= (Date)formatter.parse(testdate);
        instance.setEnvisagedpublicationdate(startDate);
       
        
        TypedQuery<Publicationdetails> query= manager.createNamedQuery("Publicationdetails.findById",Publicationdetails.class);
        query.setParameter("id",1); 
        List results=query.getResultList();
        Publicationdetails f1=(Publicationdetails) results.get(0);
        
        String expResult1= f1.getTitle(); //If set has worked successfully, title retieved should be 'title'
        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
        Date expDate= f1.getEnvisagedpublicationdate();//1f set has worked successfully, date retrieved should be o1/o1/2016
                
        String result1 = instance.getTitle();
        Integer idResult= instance.getId();
        Date result3= instance.getEnvisagedpublicationdate();
        
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
        System.out.println("Publicationdetails successfully added");
        fail ("Test Failure: New person not added");
    }

    
    
}

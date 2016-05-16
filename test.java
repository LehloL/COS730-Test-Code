@@ -0,0 +1,150 @@
 +/*
 + * To change this license header, choose License Headers in Project Properties.
 + * To change this template file, choose Tools | Templates
 + * and open the template in the editor.
 + */
 +package Entities;
 +
 +import java.text.DateFormat;
 +import java.text.ParseException;
 +import java.text.SimpleDateFormat;
 +import java.util.Date;
 +import java.util.List;
 +import javax.persistence.EntityManager;
 +import javax.persistence.EntityManagerFactory;
 +import javax.persistence.Persistence;
 +import javax.persistence.TypedQuery;
 +import org.junit.AfterClass;
 +import org.junit.BeforeClass;
 +import org.junit.Test;
 +import static org.junit.Assert.*;
 +
 +/**
 + *
 + * @author Tinashe
 + */
 +public class LifecyclestateTest {
 +    
 +    public LifecyclestateTest() {
 +    }
 +    
 +    @BeforeClass
 +    public static void setUpClass() {
 +    }
 +    
 +    @AfterClass
 +    public static void tearDownClass() {
 +    }
 +
 +    /**
 +     * Test of getId method, of class Lifecyclestate. Get existing publication lifecyclestate
 +     */
 +    @Test
 +    public void testGetId() throws ParseException {
 +          // TODO code application logic here
 +        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
 +        EntityManager manager=factory.createEntityManager();
 +        
 +        System.out.println("LifecyclestateJUnitTest: Retrieve an existing lifecycle state");
 +        
 +        TypedQuery<Lifecyclestate> query= manager.createNamedQuery("Lifecyclestate.findByBibtexentry",Lifecyclestate.class);
 +        query.setParameter("bibtexentry", "AutOnTheCloud2"); 
 +        List results=query.getResultList();
 +        Lifecyclestate f1=(Lifecyclestate) results.get(0);
 +        
 +         Integer methodTestPerc= f1.getPercentagecompleted();
 +         String methodTestState= f1.getState();
 +         Integer methodTestID= f1.getId();
 +         Date methodTestPubDate= f1.getPublicationdate();
 +         String methodTestEntry= f1.getBibtexentry();
 +         String resultDate= methodTestPubDate.toString();
 +         
 +         Integer expectedResultPerc= 90 ;
 +         String expectedResultState="Rejected";
 +         Integer expectedResultID=200;
 +         String expectedResultPubDate= "2016/03/02";
 +         String expectedResultEntry="AutOnTheCloud2";
 +         
 +         //convert date format in order to be able to assert equality
 +         String OLD_FORMAT = "EEE MMM dd hh:mm:ss zzz yyyy";
 +         String NEW_FORMAT = "yyyy/MM/dd";
 +         
 +            String oldDateString = resultDate;
 +            String newDateString;
 +
 +            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
 +            Date d = sdf.parse(oldDateString);
 +            sdf.applyPattern(NEW_FORMAT);
 +            newDateString = sdf.format(d);
 +         
 +         //check if methods work as expected
 +         assertEquals(expectedResultPerc, methodTestPerc );
 +         assertEquals(expectedResultState, methodTestState );
 +         assertEquals(expectedResultID, methodTestID );
 +         assertEquals(expectedResultPubDate, newDateString);
 +         assertEquals(expectedResultEntry, methodTestEntry);
 +        
 +         System.out.println("Lifecyclestate successfully retrieved");
 +    }
 +
 +    /**
 +     * Test of setId method, of class Lifecyclestate.
 +     */
 +    @Test
 +    public void testSetId() throws ParseException {
 +        System.out.println("LifecyclestateJUnitTest: Add a new lifecyclestate");
 +        
 +          // TODO code application logic here
 +        EntityManagerFactory factory=Persistence.createEntityManagerFactory("cos301PU"); //"JPA1" is the project name and the "PU" is added by the system
 +        EntityManager manager=factory.createEntityManager();
 +        
 +            
 +        Lifecyclestate instance = new Lifecyclestate();
 +        instance.setBibtexentry("bibtexentry");
 +        instance.setPercentagecompleted(10);
 +        instance.setId(1); 
 +        instance.setState("state");
 +        
 +        //extra work for date
 +        String testdate="01/01/2016";
 +        DateFormat formatter= new SimpleDateFormat("MM/dd/yyyy");
 +        Date startDate= (Date)formatter.parse(testdate);
 +        instance.setPublicationdate(startDate);
 +       
 +        
 +        TypedQuery<Lifecyclestate> query= manager.createNamedQuery("Lifecyclestate.findById",Lifecyclestate.class);
 +        query.setParameter("id",1); 
 +        List results=query.getResultList();
 +        Lifecyclestate f1=(Lifecyclestate) results.get(0);
 +        
 +        String expResult1= f1.getBibtexentry(); //If set has worked successfully, bibtex retieved should be 'bibtexentry'
 +        Integer expResult2= f1.getPercentagecompleted();//If set has worked successfully, percentage retieved should be 10
 +        Integer expResultID= f1.getId();//If set has worked successfully, id retrieved should be '1'
 +        Date expDate= f1.getPublicationdate();//1f set has worked successfully, date retrieved should be o1/o1/2016
 +                
 +        String result1 = instance.getBibtexentry();
 +        Integer result2= instance.getPercentagecompleted();
 +        Integer idResult= instance.getId();
 +        Date result3= instance.getPublicationdate();
 +        
 +        //convert date format in order to be able to assert equality
 +         String OLD_FORMAT = "EEE MMM dd hh:mm:ss zzz yyyy";
 +         String NEW_FORMAT = "yyyy/MM/dd";
 +            String result3Date= result3.toString();
 +            String oldDateString = result3Date;
 +            String newDateString;
 +
 +            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
 +            Date d = sdf.parse(oldDateString);
 +            sdf.applyPattern(NEW_FORMAT);
 +            newDateString = sdf.format(d);
 +         
 +         //check if methods work as expected
 +        assertEquals(expDate, newDateString);
 +        assertEquals(expResult1, result1);
 +        assertEquals(expResult2, result2);
 +        assertEquals(expResultID, idResult);
 +        System.out.println("Lifecyclestate successfully added");
 +        fail ("Test Failure: New person not added");
 +    }
 + }
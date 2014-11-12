/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.leona_service;


import br.leona.hardware.model.Service;
import br.leona.hardware.services.Pantilt;
import br.leona.station.services.ServerServices;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin_2
 */
public class JUnitTestLoena_Service {
    private static ServerServices serverServices =  new ServerServices();
    private static Pantilt pantilt = new Pantilt();
    
    public JUnitTestLoena_Service() {        
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testTurnOn();
        testIsOn();
    }
    
    @After
    public void tearDown() {                
        testTurnOff();        
        testIsOff();
        testReset();
        testIsOn();
        testTurnOff();
        testClose();
        testIsOff();
   }
    
    public void testTurnOn() {
        assertEquals(1, pantilt.turnOn());
    }
    
    public void testTurnOff() {
        assertEquals(1, pantilt.turnOff());
    }
    
    public void testReset() {
        assertEquals(1, pantilt.reset()); 
    }
   
    public void testIsOn() { 
        assertEquals(1, pantilt.isOn());
    }
    
    public void testIsOff() { 
        assertEquals(0, pantilt.isOn());
    }
        
    public void testClose()  {        
        assertEquals(1, pantilt.close());
    }

    @Test
    public void testMoveUp() {
        assertEquals(1, pantilt.moveDirection("50", "UP"));
    }  

    @Test
    public void testMovedown() {        
       assertEquals(1, pantilt.moveDirection("50", "DOWN"));
    }

    @Test
    public void testMoveLeft() { 
       assertEquals(1, pantilt.moveDirection("50", "LEFT"));
    } 

    @Test
    public void testMoveRight() { 
       assertEquals(1, pantilt.moveDirection("50", "RIGHT"));
    }   
   
    @Test
    public void testGetListaServicos(){
       List<Service> listService = new ArrayList<Service>();
       listService.addAll(serverServices.getListServices());
       assertFalse(listService.isEmpty());
       for(int i = 0; i < listService.size(); i++){
            System.out.println("Name: "+listService.get(i).getName());
            System.out.println("Status: "+listService.get(i).getStatus());            
        }
    }
   
}

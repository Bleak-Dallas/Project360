/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dallas
 */
public class CalcNextEmployeeTest {
    
    public CalcNextEmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of greaterSeniority method, of class CalcNextEmployee.
     */
    @Test
    public void testGreaterSeniority() {
        System.out.println("greaterSeniority");
        int a = 10;
        int b = 12;
        int c = 4;
        int d = 6;
        CalcNextEmployee instance = new CalcNextEmployee();
        int expResult = 4;
        int result = instance.greaterSeniority(a, b, c, d);
        assertEquals(expResult, result);
    }

    /**
     * Test of mostVolunteered method, of class CalcNextEmployee.
     */
    @Test
    public void testMostVolunteered() {
        System.out.println("mostVolunteered");
        int a = 1;
        int b = 5;
        int c = 3;
        int d = 2;
        CalcNextEmployee instance = new CalcNextEmployee();
        int expResult = 5;
        int result = instance.mostVolunteered(a, b, c, d);
        assertEquals(expResult, result);
    }
    
}

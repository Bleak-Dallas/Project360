/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.EmployeeDetails;


/**
 *
 * @author Dallas
 */
public class EmployeeControl {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String RESET = "\u001B[0m"; //Reset code
    
    // create a scanner object
    Scanner input = new Scanner(System.in);
    
     /***********************************************************************
     * GET EMPLOYEE FILE NAME
     * this method gets the employee information from the user
     * @return fileName
     ***********************************************************************/
//    public String getEmployeeFileName() {
//        String fileName;
//        
//        System.out.println("Please enter a file name for this new employye record: ");
//        fileName = input.nextLine();
//        
//        return fileName;
//    }
//    
    /***********************************************************************
     * GET EMPLOYEE DATA
     * this method gets the employee information from the user
     * @param empD
     ***********************************************************************/
    public void getEmployeeData(EmployeeDetails empD) {
        
        String employeeName;
        int emmployeeSeniority;
        String employeeHireDate;
        
        // get the employee name
        System.out.println(YELLOW + "Please enter employee name: " + RESET);
        employeeName = input.nextLine();
        empD.setEmployeeName(employeeName);
        
        // get the employee seniority
        System.out.println(YELLOW + "Please enter employee seniority: " + RESET);
        emmployeeSeniority = input.nextInt();
        empD.setEmployeeSeniority(emmployeeSeniority);
        
        // get the employee hire date
        System.out.println(YELLOW + "Please enter employee hire date (mm-dd-yyyy): " + RESET);
        employeeHireDate = input.next();
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        try {
            Date d = df.parse(employeeHireDate);
            empD.setDateHired(d);
        } 
        catch(ParseException e) {
            System.out.println("Unable to parse " + employeeHireDate);
        }

    }
}

    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import model.EmployeeDetails;
import model.EmployeeMap;
import model.HibernateFunctions;
import view.ConsoleUI;
import view.EmployeeView;

/**
 *
 * @author Dallas
 */
public class EmployeeAppController {
    
        
        CalcNextEmployee nextEmp = new CalcNextEmployee(); // not currently used
        EmployeeDetails employeeD = new EmployeeDetails();
        EmployeeControl employeeC = new EmployeeControl();
        EmployeeView employeeV = new EmployeeView();
        JSONFile fileName = new JSONFile();
        EmployeeMap map = new EmployeeMap();
        HibernateFunctions hib = new HibernateFunctions();

        // create linked map and call it to be used later
        LinkedHashMap<String, String> employeeMap;
    
    
    public void getEmployeeData() {
        // get the employee information
        employeeC.getEmployeeData(employeeD);
    }
    
    public void updateDB() {
        //send informaion to the databse to be updated
        hib.updateEmployeeDatabase(employeeD);
    }
    
    public void createJsonFile() {
        // create a JSON file
        employeeMap = map.createEmpMap(employeeD);
        fileName.createFile(employeeMap);
    }
    
    public void displayEmployeeInfo() {
        // display using the employee information
        employeeV.displayEmployeeInfo(employeeMap);
        System.out.println();
        employeeV.dispayMap(employeeMap);
    }
    
    public void displayConsole() {
        ConsoleUI cui = new ConsoleUI();
        cui.dispayConsole();
    }
    
    public void beginThreads() {
        // start threads
        System.out.println("Thread metthod begins...");

        ExecutorService exService = Executors.newFixedThreadPool(2);

        exService.execute(new LoopTaskThread());
        exService.execute(new LoopTaskThread());
        
        exService.shutdown();
        
        System.out.println("Thread method ends.");
    }    
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.LinkedHashMap;


public class EmployeeView {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String BLUE = "\u001B[34m";  // Blue color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String PURPLE = "\u001B[35m"; // Purple color
    public static final String RESET = "\u001B[0m"; //Reset code
    
    /***********************************************************************
     * DISPLAY EMPLOYEE INFORMATION
     * @param employeeMap
     **********************************************************************/
    public void displayEmployeeInfo(LinkedHashMap<String, String> employeeMap) {
        System.out.println(BLUE + "Display Class Information" + RESET);
        System.out.printf(BLUE + "Employee name: " + RESET + "%s%n" + BLUE 
                        + "Employee Seniority: " + RESET 
                        + "%s%n",employeeMap.get("name"), employeeMap.get("seniority"));
        System.out.println(BLUE + "Employee Hire Date: " + RESET + employeeMap.get("hire date"));
    }
    
    public void dispayMap(LinkedHashMap<String, String> employeeMap) {
        
       System.out.println(PURPLE + "LinkedHashMap" + RESET); // Print out type of Map
       // Print the key and values of the maps
       for (String key: employeeMap.keySet()) {
           String value = employeeMap.get(key);

           System.out.println(key + ": " + value);
       }
        System.out.println();
        }
}

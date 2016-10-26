package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;


public class EmployeeMap {
    
    // for printing purposes
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String PURPLE = "\u001B[35m";
    public static final String RESET = "\u001B[0m"; //Reset code
    
    
    public LinkedHashMap createEmpMap(EmployeeDetails empD) {
       
        LinkedHashMap<String, String> employeeMap = new LinkedHashMap<>(); // new tree map
        
        // convert the hire date to a string before putting it into the map
        String dateString = "";
        Date d = empD.getDateHired();
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        try {
            dateString = df.format(d);
        }catch (Exception ex ){
	System.out.println(ex);
        }
        
        employeeMap.put("name", empD.getEmployeeName());
        employeeMap.put("seniority", Integer.toString(empD.getEmployeeSeniority()));
        employeeMap.put("hire date", dateString);
        
        return employeeMap;
        
    }
    
}

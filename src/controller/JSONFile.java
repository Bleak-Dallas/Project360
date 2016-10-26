package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author VHASLCBleakD
 */

public class JSONFile {
    
    public static final String YELLOW = "\u001B[33m"; //Yellow color
    public static final String GREEN = "\u001B[32m"; // Green color
    public static final String CYAN = "\u001B[36m"; // Cyan color
    public static final String RESET = "\u001B[0m"; //Reset code

    public void createFile(LinkedHashMap<String, String> employeeMap) {

        // variable for JSON object name
        String name  = employeeMap.get("name");
        
        // create a new JSON object
        JSONObject root = new JSONObject();
        
        // put the name name-value pair
        root.put("name", name);
        
        //create a JSON array
        JSONArray employeeInfo = new JSONArray();
        
            // create variables to place in JSON array
            int empSeniority = Integer.parseInt(employeeMap.get("seniority"));
            // convert the date to the proper format
            String empHireDate = employeeMap.get("hire date");

            // create a JSON object and array and store a class object in it
            JSONObject unitObject1 = new JSONObject();
            unitObject1.put("Hire Date", empHireDate);
            unitObject1.put("Seniority", empSeniority);
            
            // add the course ot the array
            employeeInfo.add(unitObject1);
        
        // add the array to the root object
        root.put("EmployeeInformation", employeeInfo);
        
        System.out.println(CYAN + "Print JSON Array" + RESET);
        System.out.println(root.toJSONString());
        
        // create a file and write the JSON structure to it
        File file = new File("EmployeeInformation.txt");
        
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(root.toJSONString());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        
        System.out.println(GREEN + "File created successfully\n\n" + RESET);
        System.out.println();
        
        try {
            Scanner  input = new Scanner(System.in);
            Scanner jsonInput = new Scanner(file);
            StringBuilder jsonIn = new StringBuilder();
           while (jsonInput.hasNextLine()) {
               jsonIn.append(jsonInput.nextLine());
           }
            System.out.println(CYAN + "Print JSON FIle after retrieval" + RESET);
            System.out.println(jsonIn.toString());
            System.out.println(GREEN + "Hit Return to continue to display" + RESET);
            input.nextLine();
            
            JSONParser parser = new JSONParser();
            
            JSONObject objRoot = (JSONObject) parser.parse(jsonIn.toString());
            
            System.out.println(CYAN + "Display JSON FILE INFO" +RESET);
            System.out.printf("Employee name is %s\n", objRoot.get("name").toString());
            
            JSONArray empIn = (JSONArray) objRoot.get("EmployeeInformation");
            
            for (int i = 0; i < employeeInfo.size(); i++) {
                JSONObject empInfo = (JSONObject) empIn.get(i);
                String empHire = (String) empInfo.get("Hire Date");
                Object empSen = empInfo.get("Seniority");
                System.out.printf("Seniority: %d - Hire Date: %s \n", empSen, empHire);
                System.out.println();
            }
        } catch (FileNotFoundException | ParseException ex) {
            System.out.println(ex.toString());
        }
    }
}

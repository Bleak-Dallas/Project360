package main;

import controller.EmployeeAppController;
import view.ConsoleUI;

public class main {

    public static void main(String[] args) {
        
        EmployeeAppController appControl = new EmployeeAppController();
        
        System.out.println("Main thread begins...");
        
        ConsoleUI cui = new ConsoleUI();
        cui.dispayConsole();
        
        System.out.println("Main thread ends.");
        
        System.exit(0);

    }
    
}

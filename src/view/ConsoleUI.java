/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EmployeeAppController;
import java.util.Scanner;

/**
 *
 * @author Dallas
 */
public class ConsoleUI {
    EmployeeAppController appControl = new EmployeeAppController();
    
    public void dispayConsole() {
         
         String mainMenu = "\n"
            + "\n----------------------------------------"
            + "\n | App Menu                           |"
            + "\n ---------------------------------------"
            + "\n1 - Get Employee Data"
            + "\n2 - Display Employee Data"
            + "\n3 - Start Threads"
            + "\n4 - Exit"
            + "\n5 - "
            + "\n6 - "
            + "\n7 - "
            + "\n8 - "
            + "\n9 - "
            + "\10 - "
            + "\n---------------------------------------";
         
         Scanner in = new Scanner(System.in);
         int choice;
         do {
            System.out.println(mainMenu);
            choice = in.nextInt(); // used to for choice in switch
         
            while (choice < 1 || choice > 4) {
                System.out.print("\nError! Incorrect choice.\n");
                System.out.println(mainMenu);
                choice = in.nextInt();
        }
         
            switch(choice) {
                case 1: // get employee information
                    this.getEmployeeData();
                    this.createJsonFile();
                    break;
                case 2:  // display employee info
                    this.displayEmployeeInfo();
                    break;
                case 3: // start threads
                    this.beginThreads();
                    break;
                case 4: // exit
                    System.exit(0);
                    break;
            }
         } while (choice != 6);
    }

    private void getEmployeeData() {
        appControl.getEmployeeData();
    }
    
    private void createJsonFile() {
        appControl.createJsonFile();
    }
    
    private void displayEmployeeInfo() {
        appControl.displayEmployeeInfo();
    }
    
    private void beginThreads() {
        appControl.beginThreads();
    }

}

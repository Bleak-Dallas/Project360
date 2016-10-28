/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.LocalDate.now;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFunctions {
    

    /**********************************************************************
     * UPDATE EMPLOYEE DATABASE
     * @param empD
     *********************************************************************/
    public void updateEmployeeDatabase(EmployeeDetails empD) {
        
        EmployeeDetails employee = new EmployeeDetails();
        employee.setEmployeeName("Dallas");
        employee.setEmployeeSeniority(2);
        
        Activity activity = new Activity();
        Activity activity2 = new Activity();
        activity.setActivityName("Saturday Clinic");
        activity2.setActivityName("Flu Clinic");
        
        employee.getActivity().add(activity);
        employee.getActivity().add(activity2);

        //create a session factory in hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the employee object to the test database
        session.save(employee);
        session.save(activity);
        session.save(activity2);
        //commit the transaction to the databse
        session.getTransaction().commit();
    }
    
    public static void main(String[] args) {
        
    /**********************************************
     * This is for testing hibernate
     *********************************************/    
        
        EmployeeDetails employee = new EmployeeDetails();
        employee.setEmployeeName("Dallas");
        employee.setEmployeeSeniority(2);
        String employeeDateHired = "01-16-2014";
        
        Activity activity = new Activity();
        Activity activity2 = new Activity();
        activity.setEmployee(employee);
        activity.setActivityName("Saturday Clinic");
        String activityDate = "10-29-2016";
        activity2.setEmployee(employee);
        activity2.setActivityName("Flu Clinic");
        String activity2Date = "11-02-2016";
        
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        try {
            Date d = df.parse(activityDate);
            activity.setDate(d);
            Date d2 = df.parse(activity2Date);
            activity2.setDate(d2);
            Date d3 = df.parse(employeeDateHired);
            employee.setDateHired(d3);
        } 
        catch(ParseException e) {
            System.out.println("Unable to parse " + activityDate);
        }
        
        employee.getActivity().add(activity);
        employee.getActivity().add(activity2);

        //create a session factory in hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the employee object to the test database
        session.save(employee);
        session.save(activity);
        session.save(activity2);
        //commit the transaction to the databse
        session.getTransaction().commit();
    }
}


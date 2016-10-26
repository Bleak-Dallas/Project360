/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFunctions {
    

    /**********************************************************************
     * UPDATE EMPLOYEE DATABASE
     * @param empD
     *********************************************************************/
    public void updateEmployeeDatabase(EmployeeDetails empD) {

        //create a session factory in hibernate
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the employee object to the test database
        session.save(empD);
        //commit the transaction to the databse
        session.getTransaction().commit();
    }
}


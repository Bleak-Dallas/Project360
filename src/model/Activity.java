/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
 @Table (name="Activity")
public class Activity implements Serializable {
    
    @Id @GeneratedValue
    @Column (name="ActivityId")
    private int activityID;
    
    @Column (name="ActivityName")
    private String activityName;
    
    @Column (name="ActivityDate")
    @Temporal (TemporalType.DATE)
    private Date date;
    
    @ManyToOne ()
    @JoinColumn(name = "EmployeeId")
    private EmployeeDetails employee;


    //default constructor
    public Activity() {
        
    }


    // getters
    public int getActivityID() {
        return activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public Date getDate() {
        return date;
    }

    public EmployeeDetails getEmployee() {
        return employee;
    }


    // setters
    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployee(EmployeeDetails employee) {
        this.employee = employee;
    }
    
}

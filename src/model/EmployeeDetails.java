package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 //This tells hibernate where the table is located and the name of teh table
 @Entity
 @Table (name="EmployeeDetails")
 public class EmployeeDetails implements Serializable {
    
    // this tells hibernate that this is the prmary key
    //and the name of the column in the database 
    @Id @GeneratedValue
    @Column (name="EmployeeId") // this can be placed on top of the getter
    private int employeeId;
    
    @Column (name="EmployeeName") // this can be placed on top of the getter
    private String employeeName;
    
    @Column (name="EmployeeSeniority") // this can be placed on top of the getter
    private int employeeSeniority;
    
    @Column (name="EmployeeHireDate")
    @Temporal (TemporalType.DATE)
    private Date dateHired;
    
    @OneToMany (targetEntity = Activity.class, mappedBy = "employee")
    @Column (name="EmployeeActivity") // defines the name of the database column
    private Collection<Activity> activity = new ArrayList<>();


    //GETTERS
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeSeniority() {
        return employeeSeniority;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Collection<Activity> getActivity() {
        return activity;
    }


    //SETTERS
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeSeniority(int employeeSeniority) {
        this.employeeSeniority = employeeSeniority;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public void setActivity(Collection<Activity> activity) {
        this.activity = activity;
    }

}

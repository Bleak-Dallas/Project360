package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

 //This tells hibernate where the table is located and the name of teh table
 @Entity
 @Table (name="EMPLOYEE_DETAILS")
 public class EmployeeDetails implements Serializable {
    
    // this tells hibernate that this is the prmary key
    //and the name of the column in the database 
    @Id
    @Column (name="EMPLOYEE_ID") // this can be placed on top of the getter
    private int employeeId;
    
    @Column (name="EMPLOYEE_NAME") // this can be placed on top of the getter
    private String employeeName;
    
    @Column (name="EMPLOYEE_SENIORITY") // this can be placed on top of the getter
    private int employeeSeniority;
    
    @Column (name="EMPLOYEE_HIRE_DATE")
    @Temporal (TemporalType.DATE)
    private Date dateHired;
    

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

    
     
}

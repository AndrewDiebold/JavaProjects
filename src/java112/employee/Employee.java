/*
 *  Class: Employee
 *  Author: Andrew Diebold
 *  Create date: 12/09/2019
 *  Modification date: 12/09/2019
 *  Description:The Employee class holds getters and setters
 */

package java112.employee;

import java.io.*;
import java.sql.*;
import java.util.*;

import java112.employee.*;
import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**<strong>This class that holds getters and setters</strong>
 * @author Andrew Diebold
 *
 */

 public class Employee{

    private String employeeId;
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private String department;
    private String roomNumber;
    private String phoneNumber;


    /**
     * Empty constructor for Employee class
     */
    public Employee() {
    }


    /**
     * Returns the value of employeeId.
     * @return employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }


    /**
     * Sets the value of employeeId.
     * @param employeeId The value of employeeId.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    /**
     * Returns the value of firstName.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the value of firstName.
     * @param firstName The value of firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * Returns the value of lastName.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Sets the value of lastName.
     * @param lastName The value of lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Returns the value of socialSecurityNumber.
     * @return socialSecurityNumber
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }


    /**
     * Sets the value of socialSecurityNumber.
     * @param socialSecurityNumber The value of socialSecurityNumber.
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }


    /**
     * Returns the value of department.
     * @return department
     */
    public String getDepartment() {
        return department;
    }


    /**
     * Sets the value of department.
     * @param department The value of department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }


    /**
     * Returns the value of roomNumber.
     * @return roomNumber
     */
    public String getRoomNumber() {
        return roomNumber;
    }


    /**
     * Sets the value of roomNumber.
     * @param roomNumber The value of roomNumber.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    /**
     * Returns the value of phoneNumber.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Sets the value of phoneNumber.
     * @param phoneNumber The value of phoneNumber.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the String value.
     * @return employeeString
     */
    public String toString() {
        String employeeString = getEmployeeId() + ", "
                + getFirstName() + ", "
                + getLastName() + ", "
                + getSocialSecurityNumber() + ", "
                + getDepartment() + ", "
                + getRoomNumber() + ", "
                + getPhoneNumber();
        return employeeString;
    }
}

/*
 *  Class: Search
 *  Author: Andrew Diebold
 *  Create date: 12/09/2019
 *  Modification date: 12/09/2019
 *  Description:The Search class contains the search information for the application
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

/**<strong>This class contains the search information for the application</strong>
 * @author Andrew Diebold
 *
 */

 public class Search{

    private String searchType;
    private String searchTerm;
    private List<Employee> databaseResult;
    private boolean foundEmployee;


    /**
     *   Zero parameter constructor
     */
    public Search() {
        databaseResult = new ArrayList<>();
    }


    /**
     * This method will add the employee object to the List of found Employees
     * @param employee A object of employee.
     */
    public void addFoundEmployee(Employee employee) {
        foundEmployee = true;

        databaseResult.add(employee);
    }


    /**
     * Returns the value of enteredSearchType.
     * @return searchType
     */
    public String getSearchType() {
        return searchType;
    }


    /**
     * Sets the value of searchType.
     * @param searchType The value of searchType.
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


    /**
     * Returns the value of searchTerm.
     * @return searchTerm
     */
    public String getSearchTerm() {
        return searchTerm;
    }


    /**
     * Sets the value of searchTerm.
     * @param searchTerm The value of searchTerm.
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }


    /**
     * Returns the value of databaseQueryResult.
     * @return databaseQueryResult
     *
     */
    public List<Employee> getDatabaseResult() {
        return databaseResult;
    }


    /**
     * Sets the value of databaseQueryResult.
     * @param databaseQueryResult The value of databaseQueryResult.
     */
    public void setDatabaseResult(ArrayList<Employee> databaseResult) {
        this.databaseResult = databaseResult;
    }


    /**
     * Returns the value of queryFoundEmployee.
     * @return queryFoundEmployee
     *
     */
    public boolean getFoundEmployee() {
        return foundEmployee;
    }


    /**
     * Sets the value of queryFoundEmployee.
     * @param queryFoundEmployee The value of queryFoundEmployee.
     */
    public void setFoundEmployee(boolean foundEmployee) {
        this.foundEmployee = foundEmployee;
    }


    public String toString() {
        return getSearchType();
    }
}

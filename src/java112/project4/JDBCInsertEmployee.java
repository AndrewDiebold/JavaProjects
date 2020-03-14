package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     Andrew Diebold
 *
 */
public class JDBCInsertEmployee {

    public void runSample(String[] arguements) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            statement = connection.createStatement();

            String firstName = "'" + arguements[0] + "'";
            String lastName = "'" + arguements[1] + "'";
            String ssn = "'" + arguements[2] + "'";
            String department = "'" + arguements[3] + "'";
            String room = "'" + arguements[4] + "'";
            String phone = "'" + arguements[5] + "'";
            String queryStringInsert = "INSERT INTO employees (first_name, last_name, ssn, dept, room, phone) "
                    + "VALUES (" + firstName + "," + lastName + "," + ssn + ","
                    + department + "," + room + "," + phone + ");";
            String queryStringSelect = "SELECT * FROM employees;";

            System.out.println("queryString: " + queryStringInsert);

            statement.executeUpdate(queryStringInsert);
            resultSet = statement.executeQuery(queryStringSelect);


            System.out.println();

            while (resultSet.next()) {
                String firstNameDisplay = resultSet.getString("first_name");
                String lastNameDisplay = resultSet.getString("last_name");
                String ssnDisplay = resultSet.getString("ssn");
                String departmentDisplay = resultSet.getString("dept");
                String roomDisplay = resultSet.getString("room");
                String phoneDisplay = resultSet.getString("phone");
                System.out.println("Inserted row: " + firstNameDisplay
                        + " " + lastNameDisplay + " " + ssnDisplay + " " + departmentDisplay
                        + " " + roomDisplay + " " + phoneDisplay);
            }
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {

        JDBCInsertEmployee employees = new JDBCInsertEmployee();

        employees.runSample(args);

    }
}

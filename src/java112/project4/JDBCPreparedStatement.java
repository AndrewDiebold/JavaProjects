package java112.project4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     Andrew Diebold
 *
 */
public class JDBCPreparedStatement {

    public void runSample(String[] arguements) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            preparedStatement = connection.prepareStatement("INSERT INTO employees  values(?,?,?,?,?,?,?)");


            preparedStatement.setString(1,arguements[0]);
            preparedStatement.setString(2,arguements[1]);
            preparedStatement.setString(3,arguements[2]);
            preparedStatement.setString(4,arguements[3]);
            preparedStatement.setString(5,arguements[4]);
            preparedStatement.setString(6,arguements[5]);
            preparedStatement.executeUpdate();

            String queryStringInsert = "INSERT INTO employees VALUES (" + arguements[0] + ", "
                    + arguements[1] + ", " + arguements[2] + ", " + arguements[3] + ", "
                    + arguements[4] + ", " + arguements[5] + ")";
            String queryStringSelect = "SELECT * FROM employees;";

            System.out.println("queryString: " + queryStringInsert);

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

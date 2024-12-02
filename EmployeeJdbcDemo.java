package task12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeJdbcDemo {

    public static void main(String[] args) {
        // Step 1: Database connection details
        String db_url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "root";

        try {
            // Step 2: Establish the connection
            Connection connection = DriverManager.getConnection(db_url, user, password);

            // Step 3: Check if the connection is successful
            if (connection != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Issue in connecting");
            }

            // Step 4: Perform operations
            Statement stmt = connection.createStatement();

            // Create database and use it
            String createDB = "CREATE DATABASE IF NOT EXISTS EMPLOYEE_DB";
            String useDB = "USE EMPLOYEE_DB";
            stmt.execute(createDB);
            stmt.execute(useDB);

            // Create the table
            String createTable = "CREATE TABLE IF NOT EXISTS Employee (empcode INT,empname VARCHAR(50),empage INT,esalary DECIMAL(10, 2))";
            stmt.execute(createTable);

            // Insert data into the table
            String insertData = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES(101, 'Jenny', 25, 10000),(102, 'Jacky', 30, 20000),(103, 'Joe', 20, 40000),(104, 'John', 40, 80000),(105, 'Shameer', 25, 90000)";
            stmt.executeUpdate(insertData);

            System.out.println("Data inserted successfully!");

            // Step 5: Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

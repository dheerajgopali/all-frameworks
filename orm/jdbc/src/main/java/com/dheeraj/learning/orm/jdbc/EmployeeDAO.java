package com.dheeraj.learning.orm.jdbc;

import java.sql.*;

/**
 * Created by dgopali on 8/22/2015.
 *
 * Basic JDBC operations
 *
 * =============MYSQL props==============
 * JDBC_DRIVER = "com.mysql.jdbc.Driver";
 * DB_URL = "jdbc:mysql://localhost/EMP"
 *
 */
public class EmployeeDAO {

    // Oracle JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

    /**
     * if universitypdb is service use / before it
     * if universitypdb is SID use : before it
     */
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/universitypdb";

    //  Database credentials
    static final String USER = "employeejdbc";
    static final String PASS = "employeejdbc";

    Connection conn = null;
    Statement stmt = null;
    String sql = null;

    public void initializeContext(){
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayEmployees() {
        initializeContext();
        try {
            sql = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int empno = rs.getInt("empno");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sal = rs.getInt("sal");
                int deptno = rs.getInt("deptno");

                //Display values
                System.out.print("Empno: " + empno);
                System.out.print(", Name: " + name);
                System.out.print(", Age: " + age);
                System.out.print(", Salary: " + sal);
                System.out.println(", Department No: " + deptno);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }
    }

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.displayEmployees();
    }
}

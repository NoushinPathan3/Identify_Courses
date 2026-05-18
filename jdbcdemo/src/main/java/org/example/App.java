/*package org.example;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("JDBC sample");


        // Register driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // connection establish
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
        System.out.println(connection);
// insert / delete / update/ view the datatable
        // create statement channel
        Statement statement = connection.createStatement();

        int rowsUpdated = statement.executeUpdate(
                "UPDATE employee SET  dep='Technical' WHERE emp_id = 3"
        );

        System.out.println("Rows updated: " + rowsUpdated);

        // INSERT
        statement.executeUpdate(
                "INSERT INTO employee (emp_id,emp_name,dep,salary) " +
                        "VALUES (4, 'Sam',  'Analyst', 35000  )"
        );


// DELETE
        statement.executeUpdate(
                "DELETE FROM employee WHERE PersonID = 4"
        );


        //view data
        ResultSet resultSet =statement.executeQuery("Select emp_id,emp_name,dep,salary from employee");

        while(resultSet.next()) {
            System.out.println(resultSet.getString("emp_id")
                    +":"+resultSet.getString("emp_name")
                    +":"+resultSet.getString("dep")
                    +":"+resultSet.getString("salary"));
        }

        //close connection
        connection.close();

    }
}*/


package org.example;
import java.sql.*;


public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("JDBC sample");


        // Register driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // connection establish
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "root");
        System.out.println(connection);
// insert / delete / update/ view the datatable
        // create statement channel
        Statement statement = connection.createStatement();

        /*int rowsUpdated = statement.executeUpdate(
                "UPDATE Person SET  City='Kolkata' WHERE PersonID = 2"
        );

        System.out.println("Rows updated: " + rowsUpdated);

        // INSERT
        statement.executeUpdate(
                "INSERT INTO Person (FirstName, LastName,  Gender,  City) " +
                        "VALUES ('siva', 'test',  'M',  'Delhi')"
        );


// DELETE
        statement.executeUpdate(
                "DELETE FROM Person WHERE PersonID = 4"
        );


        //view data
        ResultSet resultSet =statement.executeQuery("Select personID,FirstName, Gender,City from Person");

        while(resultSet.next()) {
            System.out.println(resultSet.getString("personID")
                    +":"+resultSet.getString("FirstName")
                    +":"+resultSet.getString("Gender")
                    +":"+resultSet.getString("City"));
        }*/

        //close connection
        connection.close();

    }
}


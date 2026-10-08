Here’s a simple Java JDBC program that connects to a MySQL database and inserts a record into a table.

```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsertExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";

        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Set values
            ps.setInt(1, 101);
            ps.setString(2, "Rahul");
            ps.setInt(3, 20);

            // Execute INSERT query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record inserted successfully!");
            }

            // Close resources
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Database setup

First, create the database and table in MySQL:

```
CREATE DATABASE college;

USE college;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
```

### How it works

1. `DriverManager.getConnection()` establishes a connection to MySQL.
2. `PreparedStatement` prepares the `INSERT` query.
3. `setInt()` and `setString()` supply the values.
4. `executeUpdate()` executes the `INSERT` statement.
5. The connection and statement are closed after the operation.

You also need the **MySQL JDBC driver (Connector/J)** in your project's classpath.

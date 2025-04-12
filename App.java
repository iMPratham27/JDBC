import java.sql.*;

public class App {
    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost:3306/students";
            // jdbc:mysql: → Specifies that we're using JDBC with MySQL.
            // localhost → The database is running on the local computer.
            // 3306 → The default port for MySQL.
            // students → The database name is 'students'.

            String username = "your username";
            String password = "your password";

            String sql = "select name from friends"; // actual sql query

            Connection connect = DriverManager.getConnection(url, username, password);
            //Connection class→ To connect to the database.
            //DriverManager class→ To manage database connections.

            Statement st = connect.createStatement();
            //Statement class→ To execute SQL queries.
            
            ResultSet rs = st.executeQuery(sql);
            //ResultSet → To store query results.

            while (rs.next()) {  // Moves to the next row, if available
                String name = rs.getString(1); // Get name from column 1
                System.out.println(name); // Print the name
            }

            connect.close(); // close database connection

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

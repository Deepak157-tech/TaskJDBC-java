import java.sql.*;

public class FetchDataFromMySQL {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/studentdb";

        try {

            // 1. Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create Connectionclear

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/studentdb",
                    "root",
                    "kern@123");

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // 5. Fetch Data
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println(id + " " + name + " " + email );
            }

            // 6. Close Connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class NEWPROG {
    private static final String DriverManager = null;

    public static void main(String[] args) {
        String jdbcURL="jdbc:mysql://localhost:3306/sampledb";
        String username="root";
        String password="";
        try {
            Connection connection = DriverManager();
            if(connection!=null) {
                System.out.println("Connected to database");
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


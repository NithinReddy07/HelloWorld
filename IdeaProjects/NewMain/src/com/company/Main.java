package com.company;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Main {
    public static void main(String [] args) {
        String jdbcURL ="jdbc:mysql://localhost:3306/users";
        String username ="root";
        String password ="";

        try {
            Connection connection =DriverManager.getConnection(jdbcURL, username, password);

		/*String sql = "INSERT INTO myusers (id, name, email, address)" +  "VALUES('3', 'raviteja', 'ravi2@kjld.om', 'hydsdsd fksdg')";
		Statement statement =connection.createStatement();
		int rows=statement.executeUpdate(sql);*/

            String sql2 ="UPDATE myusers SET email='ravitej@.com' WHERE id='2'";
            Statement statement2= connection.createStatement();
            int rows1=statement2.executeUpdate(sql2);

            String sql3="DELETE FROM myusers WHERE id='3'";
            Statement statement3= connection.createStatement();
            int rows2=statement3.executeUpdate(sql3);



            String sql1 = "SELECT * FROM myusers";

            Statement statement1 = connection.createStatement();
            ResultSet result =statement1.executeQuery(sql1);

            while(result.next()) {
                int  userId = result.getInt("id");
                String userName = result.getString("name");
                String userEmail = result.getString("email");
                String userAddress = result.getString("address");
                System.out.println(userId +"," + userName +"," + userEmail +"," + userAddress);
            }

            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

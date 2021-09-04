package com.company;
import java.sql.*;

public class Main {

    public static  void main(String[] args) {
        String jdbcURL="jdbc:mysql://localhost:3306/sampledb";
        String username="root";
        String password=""; 

        String NAME="N";
        String Mobilenumber ="8529631478";
        String EID="456";
        String Email="nithin@gmail.com";
        String Address="kky";
        try {
            Connection connection= DriverManager.getConnection(jdbcURL,username,password);
          String sql="INSERT INTO nithin values(?,?,?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,NAME);
            statement.setString(2,Mobilenumber);
            statement.setString(3,EID);
            statement.setString(4,Email);
            statement.setString(5,Address);
         int rows = statement.executeUpdate();
            if (rows>0){
                System.out.println("a new user has been inserted succesfully");
            }
                connection.close();


        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}

package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
public class Main 
{
  public static void main(String[] args) 
  {
    Connection connection = null;
    PreparedStatement pstmt = null;
    String sql = "INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (?,?,?,?)";
    try
    {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDemo", "root", "#Sonofnun88");
       
      pstmt = connection.prepareStatement(sql);
      pstmt.setInt(1, 87);
      pstmt.setString(2, "Lokesh");
      pstmt.setString(3, "Gupta");
      pstmt.setInt(4, 5);
      int affectedRows = pstmt.executeUpdate();
      System.out.println(affectedRows + " row(s) affected !!");
    } 
    catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        pstmt.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
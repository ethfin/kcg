/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author TOPHY
 */
public class Database {

   public Connection con;
   public PreparedStatement qry;
   public ResultSet rs;
   
   public void Connect() throws SQLException {
       con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3308/stocks?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
   }
   
   public void Disconnect() throws SQLException {
       if (!con.isClosed()) {
           con.close();
       }
       if (!qry.isClosed()) {
           qry.close();
       }
       if (!rs.isClosed()) {
           rs.close();
       }
   }
    
}

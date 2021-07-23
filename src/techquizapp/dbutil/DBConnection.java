/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    
    private static Connection conn;
    static
    {
        try{
            
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver Loaded");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Nikhil-PC:1521/xe","onlineexam","student");
            //ps = conn.prepareStatement("insert into employee values (?,?,?)");
            JOptionPane.showMessageDialog(null,"connect");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"cannot able to connect to database");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try {
            
        conn.close();
        JOptionPane.showMessageDialog(null,"connection close successfully");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"cannot disconnect with DB");
            ex.printStackTrace();
        }
    }
}


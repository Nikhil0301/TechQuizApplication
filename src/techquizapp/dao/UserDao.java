/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

/**
 *
 * @author hp
 */
//onlineexam//student
public class UserDao {
   
    public static boolean validUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs = ps.executeQuery();
       
        if(rs.next())
        {
             System.out.println("rs.next():- "+rs.next());
             System.out.println("!rs.next():- "+!rs.next());
             return true;
        }  
        else
        {    
             System.out.println("rs.next():- "+rs.next());
             System.out.println("!rs.next():- "+!rs.next());
             return false;
        }
    }
    public static boolean insertUser(User user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        
        int count=ps.executeUpdate();
        System.out.println("Rec inserted:"+count);
       
        if(count==0) 
        {
               
               return false;
        }
        else
        {
              
               return true;
        }
    }
    public static boolean changePassword(User user) throws SQLException
    {
        
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
        
        ps.setString(1,user.getPassword());
        ps.setString(2,user.getUserId());
        
        int ans=ps.executeUpdate();
           
           if(ans==0)  
           {
               System.out.println("password not changed");
               return false;
           }
           else
           {
                System.out.println("password changed successfully");
                return true;
           }
        
      
        
    }
}

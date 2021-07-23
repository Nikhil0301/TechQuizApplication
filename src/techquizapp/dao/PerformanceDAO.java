/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.SQLException;
import techquizapp.pojo.Performance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Question;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.StudentScore;
public class PerformanceDAO {
    
    public static void addPerformance(Performance performance) throws SQLException
    {
           String qry="Insert into performance values(?,?,?,?,?,?,?)";
           Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement(qry);
           ps.setString(1, performance.getUserId());
           ps.setString(2, performance.getExamId());
           ps.setInt(3,performance.getRight());
           ps.setInt(4,performance.getWrong());
           ps.setInt(5,performance.getUnattempted());
           ps.setDouble(6,performance.getPer());
           ps.setString(7,performance.getLanguage());
           ps.executeUpdate();
    }
    public static boolean isPerformanceSet(String studentName) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select examid from performance where userid=?");
        //PreparedStatement ps = conn.prepareStatement("select 1 from exam where language=?");
        ps.setString(1, studentName);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static ArrayList<String> getExamIdByStudent(String userid) throws SQLException
   {
         String qry="select examid from performance where userid=?";
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(qry);
         ps.setString(1, userid);  
         ResultSet rs = ps.executeQuery();
         ArrayList<String> examIdList=new ArrayList<>();
         while(rs.next())
         {
             examIdList.add(rs.getString(1));
         }
         return examIdList;
    }
     public static String[] getreportByExamId(String examid,String USERID) throws SQLException
     {
         String qry="select language,per from performance where examid=? and USERID=?";
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(qry);
         ps.setString(1, examid);  
         ps.setString(2, USERID); 
         ResultSet rs = ps.executeQuery();
         String[] report=new String[2];
         rs.next();
         report[0]=rs.getString(1);
         report[1]= Double.toString(rs.getDouble(2));
         return report;
     }
     public static ArrayList<String> getAllExamId(String studentId) throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select examid from performance where userid=?");
         ArrayList<String>  examIdList = new ArrayList();
         ps.setString(1, studentId);
         ResultSet rs = ps.executeQuery();
         while(rs.next())
         {
             String id = rs.getString(1);
             examIdList.add(id);
         }
         return examIdList;
     }
     public static StudentScore getScore(String studentId,String examId) throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("select language,per from performance where userid=? and examid=?");
         ArrayList<String>  examIdList = new ArrayList();
         ps.setString(1, studentId);
         ps.setString(2, examId);
         ResultSet rs = ps.executeQuery();
         rs.next();
         StudentScore obj = new StudentScore();
         obj.setLanguage(rs.getString(1));
         obj.setPer(rs.getDouble(2));
         
         return obj;
     }
     public static ArrayList<String> getAllStudentId() throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         Statement st = conn.createStatement();
         ArrayList<String>  studentIdList = new ArrayList();
         ResultSet rs = st.executeQuery("select distinct userid from performance");
         while(rs.next())
         {
             String id = rs.getString(1);
             studentIdList.add(id);
         }
         return studentIdList;
          
     }
     public static ArrayList<Performance> getAllData() throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         Statement st = conn.createStatement();
         ArrayList<Performance>  performanceList = new ArrayList();
         ResultSet rs = st.executeQuery("select * from performance");
         while(rs.next())
         {
             String userid=rs.getString(1);
             String examid = rs.getString(2);
             int right = rs.getInt(3);
             int wrong = rs.getInt(4);
             int unatt = rs.getInt(5);
             double per = rs.getDouble(6);
             String lang = rs.getString(7);
             Performance p =new Performance(examid,lang,userid,right,wrong,unatt,per);
             performanceList.add(p);  
         }
         return performanceList;
     }
     
}

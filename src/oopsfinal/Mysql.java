package oopsfinal;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class Mysql {
   
   Connection conn1;
  void Insert(String a,String bmi) {
    try {

    conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi","nik","password");

    Statement mys=conn1.createStatement();
    String s="Insert into bmi(username,password) values('"+a+"',"+bmi+")";
    System.out.println(s);
    mys.executeUpdate(s);
    
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  int Login(String a,String b) {
    try {
    	
      conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi","nik","password");  //Custom
        Statement mys=conn1.createStatement();
        String s="select *  from bmi where username='"+a+"' and password ='"+b +"'";
        System.out.println(s);
          ResultSet rs=mys.executeQuery(s); 
          while(rs.next()) {
          if(rs.getString(1).equals(a) && rs.getString(2).equals(b)){
             return 1;
          }
          else{
             return 0;
          }
          }
        
        }catch(Exception e) {
          e.printStackTrace();
        }
    return 0;
      }
 }

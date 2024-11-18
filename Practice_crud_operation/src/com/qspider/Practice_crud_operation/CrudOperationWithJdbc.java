package com.qspider.Practice_crud_operation;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class CrudOperationWithJdbc {
	static String yes;
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/employees";
	String username="root";
	String password="Ashish";
	
	
		System.out.println("Welcome to basic crud operation ");
		System.out.println("Enter the your choice\n1.For insert data\n2.For update data\n3.delete data\n4.Display data ");
		int choice=sc.nextInt();
	switch (choice) {
	case 1:
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
	     	System.out.println("connection done");
	     	String insert="insert into user_detail(id,name,email,dob,doj) values(?,?,?,?,?)";
			PreparedStatement presta=connection.prepareStatement(insert);
			System.out.println("enter the id no");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.println("enter the name");
			String name=sc.nextLine();
		//	sc.next();	sc.next();
			System.out.println("enter the email id");
			String email=sc.nextLine();
		
			System.out.println("enter the date of birthday");
			String dob=sc.nextLine();
			//sc.nextLine();
			System.out.println("enter the date of joining");
			String doj=sc.nextLine();
			presta.setInt(1,id);
			presta.setString(2, name);
			presta.setString(3, email);
			presta.setString(4, dob);
			presta.setString(5, doj);
			
			int a=presta.executeUpdate();
		    System.out.println("data succesfully inserted");
		   
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println(connection);
		break;
	}
	/*this  code is the any  Updation in our database */
	case 2:
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
	     	System.out.println("connection done");
	     	System.out.println("enter the which updated id no");
	     	int id=sc.nextInt();
	     	sc.nextLine();
	     	System.out.println("what do you to update\n1.name\n2.email id\n3.date of birthday\n4.date of joining");
	     	int uchoice=sc.nextInt();
	     	sc.nextLine();
	     	switch (uchoice) {
			case 1: {
				System.out.println("enter your name");
				String name=sc.nextLine();
				
				String update="update user_detail set name= ? where id= ?";
		 	PreparedStatement presta=connection.prepareStatement(update);
				
				
				presta.setString(1, name);
				presta.setInt(2, id);
				int a=presta.executeUpdate();
				System.out.println("Name update succesfuly");
				
			}
			case 2:
			{
				System.out.println("enter your updated email id");
				String emailId=sc.nextLine();
				
				String update="update user_detail set email= ? where id= ?";
		 	PreparedStatement presta=connection.prepareStatement(update);
				
				
				presta.setString(1,emailId );
				presta.setInt(2, id);
				int a=presta.executeUpdate();
				System.out.println("Email update succesfuly");
				break;
			}
			case 3:
			{
				System.out.println("enter your updated date of birth");
				String dob=sc.nextLine();
				
				String update="update user_detail set dob= ? where id= ?";
		 	PreparedStatement presta=connection.prepareStatement(update);
				
				
				presta.setString(1,dob);
				presta.setInt(2, id);
				int a=presta.executeUpdate();
				System.out.println("Date of birth update succesfuly");
				
			}
			case 4:
			{
				System.out.println("enter your updated date of joining ");
				String doj=sc.nextLine();
				
				String update="update user_detail set doj= ? where id= ?";
		 	PreparedStatement presta=connection.prepareStatement(update);
				
				
				presta.setString(1,doj);
				presta.setInt(2, id);
				int a=presta.executeUpdate();
				System.out.println("Date of joining update succesfuly");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + uchoice);
			}
		 
		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		break;
	}
	//  this is for delete any row 
	case 3: 
	{  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
	     	System.out.println("connection done");
	     	System.out.println("enter the row deleted  id no");
	     	int id=sc.nextInt();
	     	sc.nextLine();
	     	String delete="delete from user_detail where id = ?";
	     	
	     	PreparedStatement presta=connection.prepareStatement(delete);
	     	presta.setInt(1, id);
	    	int a=presta.executeUpdate();
	    	System.out.println("row deleted successfully");
	     	
	     	
	
	     }catch (ClassNotFoundException | SQLException e) {
	 	
	    	e.printStackTrace();
	    }
	
	  finally {
	    	try {
		    	connection.close();
		       } catch (SQLException e) {
			
		     	e.printStackTrace();
		      }
	}
		break;
	}
	// this is for display the data
	case 4:
	  {
		  List l1=new ArrayList();
		  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
	     	System.out.println("connection done");
	     	String display="select * from user_detail";
	     	PreparedStatement presta=connection.prepareStatement(display);
	     	ResultSet  res=presta.executeQuery();
	     	
	     
	     	while(res.next())
	     	{
	     	int id=res.getInt("id");
	     	String name=res.getString("name");
	     	String email=res.getString("email");
	       String dob=res.getString("dob");
	      String  doj=res.getString("doj");
	       
	       String allDetail=" "+id+"| "+name+"| "+email+"| "+dob+"| "+doj;
	       
	       l1.add(allDetail);
	       
	     	}
	     	
	     	Iterator i1= l1.iterator();
	     	 while(i1.hasNext())
	     	 {
	     		 System.out.println(i1.next());
	     	 }
	     	
	     	
	     	
	        }catch (ClassNotFoundException | SQLException e) {
		
	        	e.printStackTrace();
	        }
	
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		break;
	  }
	  default:{
	         	throw new IllegalArgumentException("Unexpected value: " + choice);
	          }
	
	}
	}
} 


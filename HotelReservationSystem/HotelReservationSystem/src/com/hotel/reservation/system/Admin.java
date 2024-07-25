package com.hotel.reservation.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Admin {
	Scanner sc =new Scanner(System.in);
	private int AutoCustomerID()
	{
		int cusid=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(UserID) as NextUserID from Users where userType='Customer'");
			rs.next();
			cusid = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return cusid+1;
	}
	public int addCustomer()
	{
		int CustomerID=AutoCustomerID();
		String password;
		String cpd;
		System.out.println("Customer ID:"+CustomerID);
		System.out.println("Enter Password:");
		password=sc.next();
		while(true)
		{
			System.out.println("Confirm Password");
			cpd=sc.next();
			if(password.compareTo(cpd)==0)
					break;
		}
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("insert into Users values('"+CustomerID+"','"+"Customer"+"','"+password+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return CustomerID;
	}
	public void viewCustomer()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Customer");
			con.close();
		}
		catch(Exception e)
		{ 
			System.out.println("EXCEPTION OCCURS");
		}  
	}
	public void viewBook()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "User");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
	public void RemoveCustomer(int id)
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("delete  from Customer where customerID = "+id);
			System.out.println("Customer Removed Succesfully!!");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS"+e.getMessage());}  
	}
	
	
	

}

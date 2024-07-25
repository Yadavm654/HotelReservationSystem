package com.hotel.reservation.system;
import java.sql.*;

public class Register 
{

	public void customer_Registration(int cid,String fn,String ln,String G,String cn,int age,String Eid,String BloodGroup,String Address)
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO customer  VALUES ('"+cid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+Eid+"','"+BloodGroup+"','"+Address+"')");
			System.out.println("Registered Succesfully!!");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());} 

	}
	
	
	public void customer_Registration(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed)
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO customer  VALUES ('"+docid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+ec+"','"+Q+"','"+dt+"','"+ed+"')");
			System.out.println("Customer Added Successully");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());}  
	}

}

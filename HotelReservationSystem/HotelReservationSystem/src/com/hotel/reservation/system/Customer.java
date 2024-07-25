
package com.hotel.reservation.system;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;




public class Customer extends Person
{
	
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
	public void CustomerRegistration(int cid) /*This method add details of the patient in the patient table of EHMS database*/
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.customer_Registration(cid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
	
	 private int AutoPatientID()///This Method of Patient Class Generates the id of patient 
		{
			int id_Patient=0;
			try{
				Connection con=ConnectionProvider.getCon();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("Select MAX(userID) as 'NextPatientID' from Users");
				rs.next();
				id_Patient= rs.getInt(1);
				if(rs.wasNull())
				{
					return 1;
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return id_Patient+1;
		}
	
	 public int addCustomer() 
		{
			int CustomerID=AutoPatientID();
			String password;
			String cpd;
			System.out.println("Customer  ID:"+CustomerID);
			System.out.println("Enter Password:");
			password=sc.next();
			while(true)
			{
				System.out.println("Confirm Password");
				cpd=sc.next();
				if(password.compareTo(cpd)==0)
						break;
				else
				{
					System.out.println("Your Password is not matching!!!");
					System.out.println("*\tRE-ENTER The Password*");
				}
			}
			try
			{
				Connection con=ConnectionProvider.getCon();
				Statement st=con.createStatement();
				st.executeUpdate("insert into Users values('"+CustomerID+"','"+"Customer"+"','"+password+"')");
				System.out.println("Registered Succesfully!!");
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			return CustomerID;
			
		}
}

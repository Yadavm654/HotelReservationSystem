package com.hotel.reservation.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Booking 
{
	private  int Apid;
	private int pid;
	private String Problem;
	private int Customer_id;
	private String Customer_Name;
	private String Customer_Type;
	private String Customer_Qualification;
	private int docFees;
	private String Appointment_Status="Pending";
	private String payment_status;
	Scanner sc=new Scanner(System.in);
	private int AutoAppointmentID()
	{
		int appID=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(AppointmentID) from Appointments");
			rs.next();
			appID = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return appID+1;
	}
	public void BookAppointment(int id)

	{
		Apid=AutoAppointmentID();
		System.out.println("Appointment ID:"+Apid);
		pid=id;
		System.out.println("Book ID:"+pid);
		System.out.println("Enter your Problem:");
		Problem=sc.nextLine();
		
		Customer_id=ChooseDoctor();
		while(Customer_id==0)
		{
			System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
			Customer_id=ChooseDoctor();
		}
		Customer_Name=GetDoctorName(Customer_id);
		docFees=GetDoctorFees(Customer_id);
		Customer_Qualification=GetDoctorQualification(Customer_id);
		int d;
		System.out.println("\t** Enter 1 to confirm **");
		d=sc.nextInt();
		if(d==1)
		{
			ConfirmAppointment();
		}	
	}
	/***********************************************************************************************/ 

	private int ChooseDoctor()
	{
		System.out.println("*** Choose Doctor Type According to your problem!! ***");
		System.out.print("\t**********************************************************************************************\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t*                  1.Eyes_Specialist                                                         *\n");
        System.out.print("\t*                  2.EAR_Specialist                                                          *\n");
        System.out.print("\t*                  3.Heart_Specialist                                                        *\n");
        System.out.print("\t*                  4.Bones_Specialist                                                        *\n");
        System.out.print("\t*                  5.Lungs_Specialist                                                        *\n");
        System.out.print("\t*                  6.Kidney_Specialist                                                       *\n");
        System.out.print("\t*                  7.General_Phsysicist                                                      *\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t**********************************************************************************************\n");	
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
			{
				Customer_Type="Eye";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eye'");
					while(rs.next())
					{
						System.out.print("\t* Customer_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the customer-id which you want to choose ***");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 2:
			{
				Customer_Type="Ear";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Customer where Doctor_Type='Ear'");
					while(rs.next())
					{
						System.out.print("\t* Customer_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\tEnter the customer-id which you want to choose");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 3:
			{
				Customer_Type="Heart";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Customer where Doctor_Type='Heart'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\tEnter the doctor-id which you want to choose ");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 4:
			{
				Customer_Type="Bone";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Bone'");
					while(rs.next())
					{
						System.out.print("\t* customer_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\tEnter the customer-id which you want to choose");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 5:
			{
				Customer_Type="Lungs";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Customer where customer_Type='Lungs'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t Enter the customer-id which you want to choose ");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 6:
			{
				Customer_Type="Kidney";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from customer where custoemr_Type='Kidney'");
					while(rs.next())
					{
						System.out.print("\t* Customer_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
				}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println("\tEnter the doctor-id which you want to choose ");
					int choosedID = sc.nextInt();
					return choosedID;
			}
			case 7:
			{
				Customer_Type="General Physicist";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='General Physicist'");
					while(rs.next())
					{
						System.out.print("\t* Customer_ID :     "+rs.getInt(1)+"                         \n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  \n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         \n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     \n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      \n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\tEnter the doctor-id which you want to choose ");
					int choosedID = sc.nextInt();
					return choosedID;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			default :
		    {
		    	
		    	return 0;
		    }
		}
	}
	/***********************************************************************************************/ 
	
	private String GetDoctorName(int docID)/**/
	{
		String DoctorName = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorName = rs.getString(2);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorName;
	}
	private int GetDoctorFees(int docID)
	{
		int  DoctorFees = 0;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorFees = rs.getInt(7);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorFees;	
	}
	private String GetDoctorQualification(int docID)
	{
		String DoctorQualification = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorQualification = rs.getString(8);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorQualification;
	}
	public String billpayment(int fee)
    {
    	Payment p=new Payment();
    	System.out.println("Doctor-Fees:"+fee);
    	System.out.println("***************************************credit card details--");
    	String status=p.CreditCardDetails(fee);
    	return status;
    }
	public void ConfirmAppointment()
	{
			
			payment_status=billpayment(docFees);
			try
			
			{
				Connection con=ConnectionProvider.getCon();
				Statement st=con.createStatement();
				st.executeUpdate("INSERT INTO Appointments VALUES ('"+Apid+"','"+Problem+"','"+pid+"','"+Customer_Name+"','"+Customer_id+"','"+Customer_Type+"','"+Customer_Qualification+"','"+docFees+"','"+payment_status+"','"+Appointment_Status+"')");
				System.out.println("ThankYou For visiting us your Appointment Has Been confirmed!!!");
			}
			catch(Exception e)
			{
				System.out.println("EXCEPTION OCCURS"+e.getMessage());
			}

	}
}
package com.hotel.reservation.system;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		System.out.println(
				"\n\t******************************Hotel Reservation System***********************************\n");
		boolean check = false;
		Scanner sc = new Scanner(System.in);
		Admin a = new Admin();
		Customer c = null;
		while (true) {
			System.out.print("\t*************************************************************************\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  1. ADMIN - LOGIN                                                          *\n");
			System.out.print("\t*                  2. CUSTOMER - LOGIN                                                        *\n");
			System.out.print("\t*                  2. USER - LOGIN                                                        *\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  4. CUSTOMER-SIGN-UP                                                        *\n");
			System.out.print("\t*                                                                                            *\n");
			System.out.print("\t*                  5. EXIT                                                                   *\n");
			System.out.print("\t************************************************************************\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				boolean checkadmin = false;
				System.out.println("*****************Welcome to Admins portal***********************");
				String un;
				String pd;
				System.out.print("USERNAME-->");
				un = sc.next();
				System.out.print("Password-->");
				pd = sc.next();
				if ((un.compareTo("abc") == 0 && pd.compareTo("1234") == 0)
						|| (un.compareTo("xyz") == 0 && pd.compareTo("1234") == 0)) {
					while (true) {
						System.out.print(
								"\t**********************************************************************************************\n");
						System.out.print(
								"\t*                                                                                            *\n");
						System.out.print(
								"\t*                  1.CustomerList                                                             *\n");
						System.out.print(
								"\t*                  3.AddCustomer                                                              *\n");
						System.out.print(
								"\t*                  4.RemoveCustomer                                                      *\n");
						System.out.print(
								"\t*                  8.LOGOUT                                                                  *\n");
						System.out.print(
								"\t**********************************************************************************************\n");
						int ch = sc.nextInt();
						switch (ch) {
						case 1: {
							a.viewCustomer();
							break;
						}
						case 3: {
							int Id = a.addCustomer();
							c = new Customer();
							c.CustomerRegistration(Id);
							break;
						}
						case 4: {
							System.out.println("Enter doctorID!!");
							int id = sc.nextInt();
							a.RemoveCustomer(id);
							break;
						}

						case 8: {
							checkadmin = true;
							break;

						}
						default: {
							System.out.println("Please Choose An Appropriate Option!!!");
						}
						}
						if (checkadmin)
							break;
					}

				} else
					System.out.println("Invalid Username or Password");
				break;
			}
			case 2: {
				boolean checkCustomer = false;
				int flag = 0;
				System.out.println("*****************Welcome to Customer portal***********************");
				int id;
				String pd;
				System.out.print("ID:");
				id = sc.nextInt();
				System.out.print("Password:");
				pd = sc.next();
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * from Users");
					while (rs.next()) {
						if (rs.getInt(1) == id && rs.getString(2).compareTo("Patient") == 0
								&& (rs.getString(3).compareTo(pd) == 0)) {
							flag = 1;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (flag == 1) {
					c = new Customer();
					while (true) {
						System.out.print(
								"\t**********************************************************************************************\n");
						System.out.print(
								"\t*                                                                                            *\n");
						System.out.print(
								"\t*                  1.ViewProfile                                                             *\n");
						System.out.print(
								"\t*                  2.viewCustomer                                                           *\n");
						System.out.print(
								"\t*                  4.ViewReport                                                              *\n");
						System.out.print(
								"\t*                  7.Give FeedBack                                                           *\n");
						System.out.print(
								"\t*                  8.LOGOUT                                                                  *\n");
						System.out.print(
								"\t**********************************************************************************************\n");
						int ch = sc.nextInt();
						switch (ch) {

					

						case 8: {
							checkCustomer = true;
							break;
						}
						default: {
							System.out.println("Please Choose An Appropriate Option!!!");
						}
						}
						if (checkCustomer)
							break;
					}
				} else {
					System.out.println("Invali UserID or password!!!");
				}
				break;
			}
			case 4: {
				c = new Customer();
				int cid = c.addCustomer();
				System.out.println("*** Fill the following details ***");
				c.CustomerRegistration(cid);
				break;
			}
			case 5: {
				System.out.println("**THANKS FOR VISITING US - Have A Nice Day**");
				check = true;
				break;
			}
			default: {
				System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
			}
			}
		}
	}
}

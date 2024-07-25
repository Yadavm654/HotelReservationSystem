package com.hotel.reservation.system;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getCon()
	{
		try {
			String url="jdbc:mysql://localhost:3306/HotelReservationSystem";
			
			String uname="root";
			String pass="root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,pass);
			return con;
		}catch(Exception e) {
			return null;
		}
	}
}

package com.crm.comcast.GenericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
/**
 * author POORNIMA
 */

public class DataBaseUtility {
	Connection connection = null;
	/**
	 * this method will do the connection to database
	 * @throws Throwable
	 */
	public void connectToDB()throws Throwable{
	Driver driver =new Driver();
	DriverManager.registerDriver(driver);
	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root","root");
	}
	/**
	 * this method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		connection.close();
	}
	/**
	 * method will fetch the data from database
	 * @param query
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		 ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * method will update the data in database and it will verify
	 * @param querry
	 * @return
	 * @throws Throwable 
	 */
	public boolean updateData(String querry) throws Throwable {
		boolean flag=false;
		int result = connection.createStatement().executeUpdate(querry);
		if(result==1) {
			System.out.println("data is updated in database");
			flag=true;
		}else {
			System.out.println("data is not updated in database");
		}
		return flag;
	}
	/**
	 * this method will verify the given data is present in the database or not
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String querry,int columnNumber,String expectedData) throws Throwable {
		boolean flag=false;
		String actualData=null;
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			String data = result.getString(columnNumber);
			if(data.equals(expectedData)) {
				actualData=data;
				flag=true;
				break;
			}
		}
		if(flag=true) {
			System.out.println("data is present in database");
		}else {
			System.out.println("data is not present in database");
			
		}
		return actualData;
	}
		
				
			
			
		
	}
	



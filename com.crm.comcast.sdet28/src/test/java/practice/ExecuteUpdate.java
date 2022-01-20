package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
		try {
		// Register the driver
		 Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//Establish the connection
	
	
		//Issue the create statement
		 Statement statement = connection.createStatement();
		 
		 // Execute query
		 int result = statement.executeUpdate("insert into student values(103,'Tom', 'Computer');");
		 if(result==1) {
			 System.out.println("Database has been updated");
		 }
		 else System.out.println("Database has not been updated");
		} catch (Exception e) {
		}
		
		
		
		 // close the database connection
	finally {
		 connection.close();
	
	}
}

}

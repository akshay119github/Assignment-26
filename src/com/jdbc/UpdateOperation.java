/* Assignments 26
 * 1. Design the user table that contain id, first name, last name, city and mobile number. 
 * perform the CRUD (Create, Read, Update, Delete) operation using JDBC.  */

package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateOperation {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = null;

		try {
			// Step 1: Loading Driver Class
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Establish Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment26", "root", "Mysql123*");

			// Step 3: Create prepareStatement
			preparedStatement = connection.prepareStatement("update user set city = ? where id = ?");

			System.out.println("Enter updated city:");
			scanner = new Scanner(System.in);
			String city = scanner.next();
			System.out.println("Enter Id:");
			int id = scanner.nextInt();

			preparedStatement.setString(1, city);
			preparedStatement.setInt(2, id);

			// Step 4: Submit prepared statement to database
			int j = preparedStatement.executeUpdate();
			System.out.println("Record Updated Successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			scanner.close();
		}
	}

}

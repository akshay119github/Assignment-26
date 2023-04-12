/* Assignments 26
 * 1. Design the user table that contain id, first name, last name, city and mobile number. 
 * perform the CRUD (Create, Read, Update, Delete) operation using JDBC.  */

package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteOperation {

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
			preparedStatement = connection.prepareStatement("delete from user where id = ?");

			System.out.println("Enter the Id:");
			scanner = new Scanner(System.in);
			int id = scanner.nextInt();

			preparedStatement.setInt(1, id);

			// Step 4: Submit prepared statement to database
			int a = preparedStatement.executeUpdate();
			System.out.println("Record Deleted Successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			scanner.close();
		}
	}

}

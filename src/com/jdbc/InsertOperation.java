/* Assignments 26
 * 1. Design the user table that contain id, first name, last name, city and mobile number. 
 * perform the CRUD (Create, Read, Update, Delete) operation using JDBC.  */

package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertOperation {

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
			preparedStatement = connection
					.prepareStatement("insert into user(firstname, lastname, city, mobilenumber) values(?,?,?,?)");

			System.out.println("Enter the first name:");
			scanner = new Scanner(System.in);
			String firstname = scanner.next();
			System.out.println("Enter the last name:");
			String lastname = scanner.next();
			System.out.println("Enter the City:");
			String city = scanner.next();
			System.out.println("Enter the mobile number:");
			String mob = scanner.next();

			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, mob);

			// Step 4: Submit prepare statement to database
			int i = preparedStatement.executeUpdate();
			System.out.println(" Inserted Successfully...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			scanner.close();
		}
	}

}

/* Assignments 26
 * 1. Design the user table that contain id, first name, last name, city and mobile number. 
 * perform the CRUD (Create, Read, Update, Delete) operation using JDBC.  */

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOperation {

	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// Step 1: Loading Driver Class
			Class.forName("com.mysql.jdbc.Driver");

			// Step 2: Establish Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment26", "root", "Mysql123*");

			// Step 3: Create prepareStatement
			preparedStatement = connection.prepareStatement("select * from user");

			// Step 4: Select Operation
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				System.out.println("ID: " + resultSet.getInt(1));
				System.out.println("First Name: " + resultSet.getString(2));
				System.out.println("Last Name: " + resultSet.getString(3));
				System.out.println("City: " + resultSet.getString(4));
				System.out.println("MobileNumber: " + resultSet.getNString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}

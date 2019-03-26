
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Assignment7 {

	public static void main(String[] argv) throws SQLException, FileNotFoundException, IOException {

		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "hr",
					"orcl");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
                Statement st=conn.createStatement();
                String input="a' OR 1='1";
                ResultSet rs=st.executeQuery("SELECT * FROM user1 WHERE username='"+input+"'");
                while(rs.next())
                {
                    System.out.println(rs.getString("Username"));
                }
        }
}
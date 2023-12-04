package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

public class PersonCRUD {
	 public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
		}
	
	 public void savePerson(int id,String name,int age,long phone,String address) throws SQLException, ClassNotFoundException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setInt(3, age);
		preparedStatement.setLong(4, phone);
		preparedStatement.setString(5, address);
		 int result=preparedStatement.executeUpdate();
		 if (result!=0) 
		 {
			System.out.println("Data Inserted");
		 } 
		 else 
		 {
            System.out.println("Data not Inserted");
		 }
		 
		 connection.close();
		 
	}
	 public void fetchPerson() throws ClassNotFoundException, SQLException
	 {
		 Connection connection=getConnection();
		 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON ");
		 ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getLong("age"));
				System.out.println(resultSet.getString("phone"));
				System.out.println(resultSet.getInt("address"));
				System.out.println("***********************");
				
			}
			resultSet.close();
			connection.close();
		 
	 }
	 
	 public void updatePerson(int id,String name,int age,long phone,String address) throws ClassNotFoundException, SQLException {
		 Connection connection=getConnection();
		 PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PERSON SET NAME=? AGE=? PHONE=? ADDRESS=?O WHERE ID=?");
		 preparedStatement.setString(1, name);
		 preparedStatement.setInt(2, age);
		 preparedStatement.setLong(3, phone);
		 preparedStatement.setString(4, address);
		 preparedStatement.setInt(5, id);
		 int update =preparedStatement.executeUpdate();
		 if (update!=0) {
			System.out.println("Data Updated");
		} else {
            System.out.println("Data not Updated");
		}
		 connection.close();
		
		 
		    
		 
		
	}
	 public void deletePerson(int id) throws ClassNotFoundException, SQLException {
		 Connection connection=getConnection();
		 PreparedStatement preparedStatement=connection.prepareStatement("DELETE * FROM PERSON WHERE ID=?");
		 preparedStatement.setInt(1, id);
		 int delete=preparedStatement.executeUpdate();
		 if (delete!=0) {
			System.out.println("Data Deleted");
		} else {
            System.out.println("Data not Deleted");
		}
		
	}
	
	 

}

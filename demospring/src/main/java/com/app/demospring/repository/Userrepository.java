package com.app.demospring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.demospring.dto.Userdto;


@Repository
public class Userrepository {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/dbms_april_2023",
				"dbms_april_2023", "Ebrain@20");
		return connection;
		}

	public Userdto  user(Userdto dto) throws ClassNotFoundException, SQLException {
		Connection connection = Userrepository.getConnection();
		String insertQuery = "insert into tb_User(id,name,password)values(?,?,?)";
     	PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
     	preparedStatement.setInt(1, dto.getId());
     	preparedStatement.setString(2, dto.getName());
		preparedStatement.setString(3, dto.getPassword());
		preparedStatement.executeUpdate();	
	return dto;
}
	public static List<Userdto> getAllDetails() throws ClassNotFoundException, SQLException {
		Connection connection = Userrepository.getConnection();
		String SelectQuery = "select * from tb_User";
		PreparedStatement preparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Userdto> user=new ArrayList<Userdto>();
		while(resultSet.next()) {
			String id=resultSet.getString(1);
			String name=resultSet.getString(2);
			String password=resultSet.getString(3);
			Userdto obj=new Userdto(Integer.parseInt(id),name,password);
			user.add(obj);
	
		}
		return user;
	}

	public Userdto update(Userdto dto) throws ClassNotFoundException, SQLException {
    Connection connection = Userrepository.getConnection();
	String updateQuery = "UPDATE tb_User SET name='kavidhas' WHERE id =5";
	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
    preparedStatement.executeUpdate();
	return dto;
	}
	public String delete() throws ClassNotFoundException, SQLException {
		Connection connection = Userrepository.getConnection();
		String updateQuery = "DELETE FROM tb_User WHERE id = 6";
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
   
		preparedStatement.executeUpdate();
		return "deleted successfully";	
		
}  
	
	public static List<Userdto> getselecteddetails() throws ClassNotFoundException, SQLException {
		Connection connection = Userrepository.getConnection();
		String SelectQuery = "select a.name,a.password,a.id from tb_User a  where a.id=1";
		PreparedStatement preparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Userdto> user=new ArrayList<Userdto>();
		while(resultSet.next()) {
		
			String name=resultSet.getString(1);
			String password=resultSet.getString(2);
			String id=resultSet.getString(3);
			Userdto obj=new Userdto(Integer.parseInt(id),name,password);
			user.add(obj);
	
		}
		return user;
	
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 //	public Userdto update(Userdto dto) throws ClassNotFoundException, SQLException {
//	Connection connection = Userrepository.getConnection();
//	String updateQuery = "UPDATE tb_User SET name=?,password=? WHERE id =?";
//	PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
// 	preparedStatement.setInt(3, dto.getId());
// 	preparedStatement.setString(1, dto.getName());
//	preparedStatement.setString(2, dto.getPassword());
//	preparedStatement.executeUpdate();
//	return dto;	
//}
	
//		public String delete(Integer id) throws ClassNotFoundException, SQLException {
//			Connection connection = Userrepository.getConnection();
//			String updateQuery = "DELETE FROM tb_User WHERE id='"+id+"'";
//			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
//	   
//			preparedStatement.executeUpdate();
//			return "deleted successfully";	
//	}  
	//"DELETE FROM tb_User WHERE id=?";
		


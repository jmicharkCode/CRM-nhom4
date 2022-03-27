package cybersoft.javabackend.java16.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.java16.crmapp.config.MySQLConnection;
import cybersoft.javabackend.java16.crmapp.model.User;


public class UserDao {

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		String query = "select id, email, password, name, address, phone, role_id from user";
		Connection connection = MySQLConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				list.add(new User(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getInt(7)
						));
			}
			
		} catch (SQLException e) {
			// TODO: 
			System.out.println("Error in select query.");
			e.printStackTrace();
		} 
		return list;
	}
	public int addUser(User user) {
		String query = "insert into user(email, password, name, address, phone, role_id) values (?,?,?,?,?,?)";
        Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPhone());
			statement.setInt(6, user.getRole());
			ResultSet result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO: 
			System.out.println("Error in select query.");
			e.printStackTrace();
		} 
		return 0;
	}
}

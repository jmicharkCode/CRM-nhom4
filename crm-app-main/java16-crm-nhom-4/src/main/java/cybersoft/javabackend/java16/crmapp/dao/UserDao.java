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
		String query = "select id, email, password, name, address, phone from user";
		Connection connection = MySQLConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				list.add(new User(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getString(6)
						
						));
			}
			
		} catch (SQLException e) {
			// TODO: 
			System.out.println("Error in select query.");
			e.printStackTrace();
		} 
		return list;
	}
	public boolean addUser(User user) {
		String query = "insert into user(email, password, name, address, phone) values (?,?,?,?,?)";
        Connection connection = MySQLConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getPhone());
			int res =  statement.executeUpdate();
			if(res > 0) return true;
		} catch (SQLException e) {
			
			System.out.println("Error!!.");
			e.printStackTrace();
		} 
		return false;
	}
	public void delete(String id) {
		String query = "DELETE FROM crm.user WHERE id = ?";
		try (Connection conn = MySQLConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, id);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void update(String id, String name, String email, String address, String phone) {

		try (Connection conn = MySQLConnection.getConnection()) {
			String query = "UPDATE crm.user set name = ?, email = ?, phone = ?, address = ?  WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, phone);
			statement.setString(4, address);
			
			statement.setString(5, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

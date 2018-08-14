package com.Web.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Web.models.User;
import com.Web.repo.interfaces.RegistrationRepositoryInterface;
import com.Web.utils.DBConnection;

public class RegistrationRepoImpl implements RegistrationRepositoryInterface{

	private DBConnection conn;
	private Statement stmt;
	private ResultSet rs;
	private User user;
	private List<User> list;
	
	public RegistrationRepoImpl() {
		super();
		conn = new DBConnection();
		stmt = null;
		rs = null;
		user = null;
		list = new ArrayList<User>();
	}


	
	@Override
	public void save(User user) {
		
		String query = "INSERT INTO USER(FIRSTNAME, LASTNAME, USERNAME, ADDRESS, EMAIL, PHONE, PASSWORD)"
				+ " VALUES('"+ user.getFirstName() +"', '"+ user.getLastName() +"', '"+ user.getUsername() +"', '"+ user.getAddress() +"', '"+ user.getEmail() +"', '"+ user.getPhone() +"', '"+ user.getPassword() +"' )";
		
		try {
			stmt = conn.getConnection().createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(User reg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		
		list.clear();

		String query = "SELECT * FROM USER";
		
		try {
			stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				user = new User(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), 
						rs.getString("USERNAME"), rs.getString("ADDRESS"), rs.getString("EMAIL"), 
						rs.getString("PHONE"), rs.getString("PASSWORD"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public User getByUserName(String username) {
		
		String query = "SELECT * FROM USER WHERE USERNAME= + '"+username+"' ";
		
		try {
			stmt = conn.getConnection().createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs != null && rs.next()) {
				user = new User(rs.getString("FIRSTNAME"), rs.getString("LASTNAME"), 
						rs.getString("USERNAME"), rs.getString("ADDRESS"), rs.getString("EMAIL"), 
						rs.getString("PHONE"), rs.getString("PASSWORD"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	
}

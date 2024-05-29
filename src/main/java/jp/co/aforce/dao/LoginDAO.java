package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.Customer;

public class LoginDAO extends DAO{
	public Customer search(String login_name, String password) throws Exception{
		Customer customer = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
			("SELECT * FROM login WHERE login_name=? AND password=?");
		st.setString(1, login_name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			customer= new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin_name(rs.getString("login_name"));
			customer.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return customer;
	}
	
	public Customer search(String login_name) throws Exception{
		Customer customer = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement
			("SELECT * FROM login WHERE login_name=?");
		st.setString(1, login_name);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			customer= new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin_name(rs.getString("login_name"));
			customer.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return customer;
	}
	
	public void insert(String login_name, String password)throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st= con.prepareStatement
				("INSERT INTO login(login_name, password) values(?,?)");
		st.setString(1, login_name);
		st.setString(2, password);
		st.executeUpdate();
		
		st.close();
		con.close();
	}
	
}

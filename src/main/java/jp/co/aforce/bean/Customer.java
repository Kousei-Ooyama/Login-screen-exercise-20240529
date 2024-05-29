package jp.co.aforce.bean;

public class Customer {
	private int id;
	private String login_name;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public String getLogin_name() {
		return login_name;
	}
	
	public String getPassword() {
		return password;
	}
}

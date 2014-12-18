package dao;

import beans.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.*;

@ManagedBean(name="userDao")
@SessionScoped
public class UserDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public void createUser(User hello){
		this.user = hello;
		
		try{
			createConnection();
			Statement st = getCon().createStatement();
			st.executeUpdate("INSERT INTO mein1.users(username, pwd) VALUES (\"" + this.user.getUserName() + "\",\"" + this.user.getPwd() + "\");");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public User getHello() {
		return user;
	}

	public void setHello(User hello) {
		this.user = hello;
	}
}

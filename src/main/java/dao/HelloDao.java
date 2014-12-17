package dao;

import beans.Hello;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.*;

@ManagedBean(name="helloDao")
@SessionScoped
public class HelloDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	private Hello hello;
	
	public void createUser(Hello hello){
		this.hello = hello;
		
		try{
			createConnection();
			Statement st = (Statement) getCon().createStatement();
			st.executeUpdate("INSERT INTO user VALUES (" + this.hello.getName() + "," + this.hello.getPwd() + ");");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Hello getHello() {
		return hello;
	}

	public void setHello(Hello hello) {
		this.hello = hello;
	}
	
}

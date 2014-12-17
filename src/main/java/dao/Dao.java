package dao;

import java.io.Serializable;
import java.sql.*;

public class Dao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private java.sql.Connection con = null;
	private final String url = "jdbc:mysql://localhost:3306/mysql";
	private final String user = "root";
	private final String pwd = "killhim19";
	
	public void createConnection(){
		try{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.con = DriverManager.getConnection(url,user,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public java.sql.Connection getCon() {
		return con;
	}

	public void setCon(java.sql.Connection con) {
		this.con = con;
	}
}

package dao;

import java.io.Serializable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao implements Serializable {
	private static final long serialVersionUID = 1L;

	private java.sql.Connection con = null;
	private final String mySQLjndi = "java:/datasources/mysql56";

	public void createConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(mySQLjndi);
			this.con = ds.getConnection();

		} catch (Exception e) {
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

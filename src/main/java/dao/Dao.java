package dao;

import java.io.Serializable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao implements Serializable {
	private static final long serialVersionUID = 1L;

	private java.sql.Connection con = null;
	private final String url = "jdbc:mysql://localhost:3306/mysql56";
	private final String user = "root";
	private final String pwd = "killhim19";

	public void createConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:/datasources/mysql56");
			//DataSource ds = (DataSource) ApplicationContextProvider.getApplicationContext().getBean("myDataSource");
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

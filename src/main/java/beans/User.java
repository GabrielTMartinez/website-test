package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="user")
@SessionScoped
@Entity
@Table (name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;
	//@ManagedProperty(value="#{pwd}")
	private String pwd;
 

	public void printAttrs(){
		System.out.println(userName);
		System.out.println(pwd);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Id
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
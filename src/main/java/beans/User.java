package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int user_id;
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
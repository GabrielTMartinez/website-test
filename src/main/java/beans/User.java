package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="user")
@SessionScoped
@Entity (name="ent_user")
@Table (name="users", schema="mein1")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//private int userId;
	private String userName;
	//@ManagedProperty(value="#{pwd}")
	private String pwd;
	
	public User(){
		
	}
	
	@Column (name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column (name="pwd")
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/*@Id
	@Column (name="user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}*/
}
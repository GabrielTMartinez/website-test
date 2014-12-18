package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hello")
@SessionScoped
public class Hello implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@ManagedProperty(value="#{name}")
	private String name;
	//@ManagedProperty(value="#{pwd}")
	private String pwd;
 

	public void printAttrs(){
		System.out.println(name);
		System.out.println(pwd);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
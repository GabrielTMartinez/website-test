package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="helloDataUser")
@SessionScoped
public class HelloDataUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Hello h;

	public void printH(Hello helloToPrint){
		this.h = helloToPrint;
		System.out.println("Name: " + h.getName() + " | Pwd: " + h.getPwd());
	}
	
	public Hello getH() {
		return h;
	}

	public void setH(Hello h) {
		this.h = h;
	}
	
}

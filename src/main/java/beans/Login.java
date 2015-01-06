package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import dao.UserDao;

@ManagedBean(name="login")
@SessionScoped
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	static private String message;
	
	public void checkLogin (User user){
		User newUser;
		UserDao dao = new UserDao();
		newUser = dao.getUser(user);
		if (newUser != null) {
			message = "Login realizado com sucesso!";
		}else{
			message = "Login falhou!";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		Login.message = message;
	}
	
}

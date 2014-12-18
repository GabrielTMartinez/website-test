package dao;

import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beans.User;

@ManagedBean(name="userDao")
@SessionScoped
public class UserDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public EntityManagerFactory createEntityManagerFactory(){
		return Persistence.createEntityManagerFactory("org.hibernate");
	}
	
	public void createUserJPA(User hello){
		EntityManager entityManager = createEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(hello);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void createUser(User hello){
		this.user = hello;
		
		try{
			createConnection();
			Statement st = getCon().createStatement();
			st.executeUpdate("INSERT INTO mein1.users(username, pwd) VALUES (\"" + this.user.getUserName() + "\",\"" + this.user.getPwd() + "\");");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public User getHello() {
		return user;
	}

	public void setHello(User hello) {
		this.user = hello;
	}
}

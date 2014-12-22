package dao;

import java.sql.Statement;

import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import beans.User;

@ManagedBean(name="userDao")
@SessionScoped
@Stateful
public class UserDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	/*@Resource
	UserTransaction ut;*/
	@PersistenceContext (unitName="fucker")
	private static EntityManager entityManager;
	
	public EntityManagerFactory createEntityManagerFactory(){
		//return Persistence.createEntityManagerFactory("org.hibernate");
		//return Persistence.createEntityManagerFactory("org.hibernate.jpa.HibernatePersistenceProvider");
		System.out.println("-----------------------1111111111111---------------------------");
		return Persistence.createEntityManagerFactory("fucker");
	}
	
	public void createUserJPA(User hello){
		System.out.println("-----------------------3333333333333---------------------------");
		entityManager = createEntityManagerFactory().createEntityManager();
		System.out.println("-----------------------4444444444444---------------------------");
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
			st.executeUpdate("INSERT INTO mein1.users(username, pwd) VALUES (\"" + this.user.getName() + "\",\"" + (this.user.getPassword()).toString() + "\");");
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

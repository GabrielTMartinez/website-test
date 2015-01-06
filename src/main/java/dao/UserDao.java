package dao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.User;

@ManagedBean(name="userDao")
@RequestScoped
public class UserDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger("userDao");
	
	@PersistenceUnit (unitName="user-unit")
	private EntityManagerFactory emFactory;
	
	public void createUserJPA(User user){
		try{
			EntityManager entityManager;
			logger.info("Creating EntityManager...");
			entityManager = this.getEntityManager();
			logger.info("Done!");
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	
	public User getUser(User user){
		User sought = null;
		try{
			EntityManager entityManager;
			logger.info("Creating EntityManager...");
			entityManager = getEntityManager(); 
			logger.info("Done!");
			entityManager.getTransaction().begin();
			sought = entityManager.find(User.class, user.getName());
			entityManager.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return sought;
	}
	
	/*public void createUser(User hello){
		this.user = hello;
		
		try{
			createConnection();
			Statement st = getCon().createStatement();
			st.executeUpdate("INSERT INTO mein1.users(username, pwd) VALUES (\"" + this.user.getName() + "\",\"" + (this.user.getPassword()).toString() + "\");");
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}

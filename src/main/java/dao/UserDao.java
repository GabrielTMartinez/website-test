package dao;

import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import beans.User;

@ManagedBean(name="userDao")
@SessionScoped
public class UserDao extends Dao  {
	private static final long serialVersionUID = 1L;
	
	//private static Logger logger = LogManager.getLogger(UserDao.class);
	
	private User user;
	
	//@Resource (mappedName="java:/datasources/mysql56")
	//UserTransaction ut;
	//@PersistenceContext (unitName="user-unit", type = PersistenceContextType.EXTENDED)
	@PersistenceUnit (unitName="user-unit")
	private EntityManagerFactory emFactory;
	//@PersistenceContext (unitName="user-unit")
	//private EntityManager entityManager;
	
	public void createUserJPA(User hello){
		try{
			EntityManager entityManager;
			//logger.info("Calling method for entity manager factory...");
			//ut.begin();
			//emFactory = createEntityManagerFactory();
			entityManager = emFactory.createEntityManager();
			//logger.info("Done!");
			entityManager.getTransaction().begin();
			entityManager.persist(hello);
			entityManager.getTransaction().commit();
			entityManager.close();
			//ut.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
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

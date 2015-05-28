package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.LoginDAO;
import Factory.HibernateSessionFactory;
import Model.Login;


public class LoginControl {
	public static Boolean isUser(String username,String password)
	{
		try{
			Login login = LoginControl.getLoginControl().getLoginByName(username);
			if(password.equals(login.getPassword()))
				return true;
				else
					return false;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public static int getUserRoll(String username)
	{
		try{
			Login login = LoginControl.getLoginControl().getLoginByName(username);
			return Integer.valueOf(login.getRole());
		}catch(Exception e){
			return -1;
		}
	}
	
		private static LoginControl control = null; 
		public static LoginControl getLoginControl(){
			if(null==control){
				control = new LoginControl();
			}
			return control;
		}
		

		private LoginDAO LoginDAO = null;
		private Session session = null;
		
		private LoginControl(){
			LoginDAO = new LoginDAO();
			session = HibernateSessionFactory.getSession();
		}
		

		public Login saveLogin(String username,String password,String role){
			Login Login = new Login(username,password,role);
			LoginDAO.save(Login);
			session.beginTransaction().commit();
			session.flush();
			return Login;
		}
	    
		public Login getLoginByName(String username){
			
		  return (Login)LoginDAO.findByProperty("userName",username).get(0);

		}
		public List getLoginALL()
		{
			return LoginDAO.findAll();
		}
		public Boolean delete(Login login) {
			try {

				LoginDAO.delete(login);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}
		
		
		public Boolean merge(Login login) {
			try {

				LoginDAO.merge(login);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}

}

package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.ParkingtotalDAO;
import Factory.HibernateSessionFactory;
import Model.Parking;
import Model.Parkingtotal;

public class ParkingtotalControl {

	private static ParkingtotalControl control = null; 
	public static ParkingtotalControl getParkingtotalControl(){
		if(null==control){
			control = new ParkingtotalControl();
		}
		return control;
	}
	
	private ParkingtotalDAO roomtotalDao =null;
	private Session session = null;
	
	private ParkingtotalControl(){
		roomtotalDao =new  ParkingtotalDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	public List getParkingtotalALL()
	{
		return roomtotalDao.findAll();
	}
	
	public List getParkingtotalByParkingType(Parking parking)
	{
		try{
			return roomtotalDao.findByProperty("parking",parking);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public Boolean merge(Parkingtotal parkingtotal) {
		try {

			roomtotalDao.merge(parkingtotal);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}

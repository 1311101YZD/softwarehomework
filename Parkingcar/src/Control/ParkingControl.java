package Control;


import java.util.List;

import org.hibernate.Session;

import Dao.ParkingDAO;
import Factory.HibernateSessionFactory;
import Model.Parking;

public class ParkingControl {
	private static ParkingControl control = null; 
	public static ParkingControl getRoomControl(){
		if(null==control){
			control = new ParkingControl();
		}
		return control;
	}
	
	private ParkingDAO ParkingDAO = null;
	private Session session = null;
	
	private ParkingControl(){
		ParkingDAO = new ParkingDAO();

		session = HibernateSessionFactory.getSession();
	}
	
	public Parking getRoomByParkingID(String ParkingID){
		Parking room= ParkingDAO.findById(ParkingID);
		   return room;
		}
		public List getRoomALL()
		{
			return ParkingDAO.findAll();
		}
	    
		public List getRoomByRoomType(String ParkingType)
		{
			return ParkingDAO.findByParkingType(ParkingType);
			
		}
		public Boolean update(Parking parking)
		{
			try
			{
				ParkingDAO.merge(parking);
				session.beginTransaction().commit();
				session.flush();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
	
}

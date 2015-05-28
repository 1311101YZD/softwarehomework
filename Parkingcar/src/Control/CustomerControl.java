package Control;

import java.util.List;

import org.hibernate.Session;

import Dao.CustomerDAO;
import Factory.HibernateSessionFactory;
import Model.Customer;
import Model.Parking;

public class CustomerControl {
	
	private static CustomerControl control = null;
	public static CustomerControl getCustomerControl(){
		if(null==control){
			control = new CustomerControl();
		}
		return control;
	}

	private CustomerDAO CustomerDAO = null;
	
	private Session session = null;
	private CustomerControl(){
		CustomerDAO =new CustomerDAO();
	
		session =HibernateSessionFactory.getSession();
	}
	
	public Customer getCustomerByCustomerID(String CustomerID){
		Customer temp;
		try{
			temp = CustomerDAO.findById(CustomerID);
		}
		catch(Exception e)
		{
			temp =null;
		}
		return temp;
	}
	
	public List getCustomerByCustomerName(String Customername){
		List temp;
		try{
			temp = CustomerDAO.findByName(Customername);
		}
		catch(Exception e)
		{
			temp =null;
		}
		return temp;
	}
	public Customer getCustomerByParkingID(String ParkingID){
		Customer temp;
		try{
			temp = CustomerDAO.findById(ParkingID);
		}
		catch(Exception e)
		{
			temp =null;
		}
		return temp;
	}
	
	public List getCustomerALL()
	{
		return CustomerDAO.findAll();
	}
	
	public Customer getCustomerByParking(Parking parking){
		
		List list = CustomerDAO.findByProperty("parking", parking);
		if(list==null)
			return null;
		return  (Customer)(list.get(0));
	}
	
	public Customer getCustomerByParking2(Parking parking){
		
		List list = CustomerDAO.findByProperty("parking", parking);
		if(list==null)
			return null;
		return  (Customer)(list.get(1));
	}
	
	public Boolean save(Customer temp)
	{
		try{
			CustomerDAO.save(temp);
			session.beginTransaction().commit();
			session.flush();
			return true;
		}
		catch (Exception e)
    	{
    		return false;
    	}
    }
	
	public Boolean update(Customer customer)
	{
		try{
			CustomerDAO.merge(customer);
			session.beginTransaction().commit();
			session.flush();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public Boolean deleteCustomer(Customer c)
	{
		try{
			CustomerDAO.delete(c);
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

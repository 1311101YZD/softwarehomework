package Control;


import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import Dao.BookDAO;
import Factory.HibernateSessionFactory;
import Model.Book;
import Model.Parking;


public class BookControl {
	public static BookControl control = null;
	public static BookControl getControl()
	{
		if(control  ==null)
			control  = new BookControl();
		return control;
	}
	private Session session;
	private BookDAO bookDao;
	public BookControl()
	{
		session = HibernateSessionFactory.getSession();
		bookDao = new BookDAO();
	}
	public List findByReName(String name)
	{
		try{
			return bookDao.findByBookName(name);
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public Boolean save(Model.Book temp)
    {
    	try{
    		bookDao.save(temp);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
	public List findAll()
    {
    	try
    	{
    		return bookDao.findAll();
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    }  

    public Boolean delete(Book temp)
    {
    	try{
    		//Book temp =(Book)bookDao.findByProperty("parking",parking).get(0);
    		bookDao.delete(temp);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    public List findByParking(Parking parking)
	{
		try{
			return bookDao.findByProperty("Parking",parking);
		}
		catch(Exception e)
		{
			return null;
		}
	}
    public Boolean update(Book temp)
	{
		try{
			bookDao.merge(temp);
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
package Dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Parking;

/**
 * A data access object (DAO) providing persistence and search support for
 * Parking entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Dao.Parking
 * @author MyEclipse Persistence Tools
 */
public class ParkingDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ParkingDAO.class);
	// property constants
	public static final String PARKING_TYPE = "parkingType";
	public static final String PARKING_STATUS = "parkingStatus";
	public static final String PARKING_TEL = "parkingTel";

	public void save(Parking transientInstance) {
		log.debug("saving Parking instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Parking persistentInstance) {
		log.debug("deleting Parking instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Parking findById(java.lang.String id) {
		log.debug("getting Parking instance with id: " + id);
		try {
			Parking instance = (Parking) getSession().get("Model.Parking", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Parking instance) {
		log.debug("finding Parking instance by example");
		try {
			List results = getSession().createCriteria("Model.Parking")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Parking instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Parking as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParkingType(Object parkingType) {
		return findByProperty(PARKING_TYPE, parkingType);
	}

	public List findByParkingStatus(Object parkingStatus) {
		return findByProperty(PARKING_STATUS, parkingStatus);
	}

	public List findByParkingTel(Object parkingTel) {
		return findByProperty(PARKING_TEL, parkingTel);
	}

	public List findAll() {
		log.debug("finding all Parking instances");
		try {
			String queryString = "from Parking";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Parking merge(Parking detachedInstance) {
		log.debug("merging Parking instance");
		try {
			Parking result = (Parking) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Parking instance) {
		log.debug("attaching dirty Parking instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Parking instance) {
		log.debug("attaching clean Parking instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
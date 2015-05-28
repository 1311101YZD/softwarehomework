package Dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.Parkingtotal;

/**
 * A data access object (DAO) providing persistence and search support for
 * Parkingtotal entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Dao.Parkingtotal
 * @author MyEclipse Persistence Tools
 */
public class ParkingtotalDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ParkingtotalDAO.class);
	// property constants
	public static final String PARKING_COUNT = "parkingCount";

	public void save(Parkingtotal transientInstance) {
		log.debug("saving Parkingtotal instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Parkingtotal persistentInstance) {
		log.debug("deleting Parkingtotal instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Parkingtotal findById(java.lang.String id) {
		log.debug("getting Parkingtotal instance with id: " + id);
		try {
			Parkingtotal instance = (Parkingtotal) getSession().get(
					"Dao.Parkingtotal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Parkingtotal instance) {
		log.debug("finding Parkingtotal instance by example");
		try {
			List results = getSession().createCriteria("Model.Parkingtotal")
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
		log.debug("finding Parkingtotal instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Parkingtotal as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParkingCount(Object parkingCount) {
		return findByProperty(PARKING_COUNT, parkingCount);
	}

	public List findAll() {
		log.debug("finding all Parkingtotal instances");
		try {
			String queryString = "from Parkingtotal";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Parkingtotal merge(Parkingtotal detachedInstance) {
		log.debug("merging Parkingtotal instance");
		try {
			Parkingtotal result = (Parkingtotal) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Parkingtotal instance) {
		log.debug("attaching dirty Parkingtotal instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Parkingtotal instance) {
		log.debug("attaching clean Parkingtotal instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
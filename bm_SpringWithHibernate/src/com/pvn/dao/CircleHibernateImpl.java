package com.pvn.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CircleHibernateImpl 
{
	@Autowired
	private SessionFactory sessionFactory;

	public int getCirclesCount()
	{
		String hql="select count(*) from Circle";
		Query query = sessionFactory.openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

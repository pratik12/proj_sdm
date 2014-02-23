package com.sdm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.sdm.model.User;
import com.sdm.util.HibernateUtil;


public class UserDAO {
		@SessionTarget
		Session session;
		
		@TransactionTarget
		Transaction transaction;
		
		@SuppressWarnings("unchecked")
		public List<User> getUsers()
		   {
		      List<User> users = new ArrayList<User>();
		      session = HibernateUtil.getSessionFactory().getCurrentSession();
		      try
		      {
		         users = session.createQuery("from User").list();
		      }
		      catch(Exception e)
		      {
		         e.printStackTrace();
		      }
		      return users;
		   }
		
		public void addUser(User user)
		   {
			try{
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				transaction = session.beginTransaction();
				session.save(user);
			}
			catch(Exception e){
				if (transaction!=null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			transaction.commit();
		   }
		
}

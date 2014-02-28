
package com.sdm.DAO;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.sdm.model.Nurse;
import com.sdm.model.User;
import com.sdm.util.HibernateUtil;

public class NurseDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	public Nurse addNurse(Nurse nurse){
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(nurse);
			System.out.println("Doctor with User is saved..");
		}
		catch(Exception e){
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		transaction.commit();
		return nurse;
	}
	
	@SuppressWarnings("unchecked")
	public List<Nurse> getNurses()	
	   {
	      List<Nurse> nurses = new ArrayList<Nurse>();
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      try
	      {
	         nurses = session.createQuery("from Nurse").list();
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return nurses;
	   }
	
	public Nurse getNurse(User user)	
	   {
	      Nurse nurse = null;
	      String hql = "FROM NURSE WHERE USER.USER_ID = :userId";
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      try
	      {
	    	  Query query = session.createQuery(hql);
	    	  query.setParameter(":userId", user.getUserId());
	    	  nurse = (query.list() != null) ?(Nurse)query.list().get(0) : null;
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return nurse;
	   }
	
	public Nurse getNurse(int nurseId)	
	   {
	      Nurse nurse = null;
	      String hql = "FROM NURSE WHERE NURSE_ID = :nurseId";
	      session = HibernateUtil.getSessionFactory().getCurrentSession();
	      try
	      {
	    	  Query query = session.createQuery(hql);
	    	  query.setParameter(":nurseId", nurseId);
	    	  nurse = (query.list() != null) ?(Nurse)query.list().get(0) : null;
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return nurse;
	   }
}

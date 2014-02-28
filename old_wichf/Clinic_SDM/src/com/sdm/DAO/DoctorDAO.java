package com.sdm.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.sdm.model.Doctor;
import com.sdm.util.HibernateUtil;

public class DoctorDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	public void addDoctor(Doctor doctor)
	   {
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(doctor);
			System.out.println("Doctor with User is saved..");
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

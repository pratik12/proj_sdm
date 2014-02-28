package com.sdm.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.sdm.model.Patient;
import com.sdm.util.HibernateUtil;


public class PatientDAO {
		@SessionTarget
		Session session;
		
		@TransactionTarget
		Transaction transaction;
		
		@SuppressWarnings("unchecked")
		public List<Patient> getPatients()
		   {
		      List<Patient> patients = new ArrayList<Patient>();
		      session = HibernateUtil.getSessionFactory().getCurrentSession();
		      try
		      {
		    	  patients = session.createQuery("from Patient").list();
		      }
		      catch(Exception e)
		      {
		         e.printStackTrace();
		      }
		      return patients;
		   }
		
		public Patient addPatient(Patient patient)
		   {
			try{
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				transaction = session.beginTransaction();
				session.save(patient);
			}
			catch(Exception e){
				if (transaction!=null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			transaction.commit();
			return patient;
		   }

		
		
}

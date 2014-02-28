package com.sdm.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.sdm.model.Appointment;
import com.sdm.model.Doctor;
import com.sdm.model.Nurse;
import com.sdm.model.User;
import com.sdm.util.HibernateUtil;


public class AppointmentDAO {
		@SessionTarget
		Session session;
		
		@TransactionTarget
		Transaction transaction;
		
//		@SuppressWarnings("unchecked")
//		public List<User> getUsers()	
//		   {
//		      List<User> users = new ArrayList<User>();
//		      session = HibernateUtil.getSessionFactory().getCurrentSession();
//		      try
//		      {
//		         users = session.createQuery("from User").list();
//		      }
//		      catch(Exception e)
//		      {
//		         e.printStackTrace();
//		      }
//		      return users;
//		   }
		
//		public User getUserById(String userId)	
//		   {
//		      User user=null;
//		      session = HibernateUtil.getSessionFactory().getCurrentSession();
//		      String hql = "FROM USER WHERE USER_ID= :userId";
//		      try
//		      {
//		         Query query = session.createQuery(hql);
//		         query.setParameter("userId", userId);
//		         user = (query.list() != null)? (User)query.list().get(0):null;
//		      }
//		      catch(Exception e)
//		      {
//		         e.printStackTrace();
//		      }
//		      return user;
//		   }
		public void initializeTransaction()
		{
			try{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
		}
		catch(Exception e){
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
		public Appointment saveAppointment(Appointment appointment)
		   {
			initializeTransaction();
//			DetachedCriteria c = DetachedCriteria.forClass(Appointment.class);
//			c.add(Restrictions.eq(String.valueOf(appointment.getDoctor().getDoctorId()), 45));
//			c.getExecutableCriteria(session).;
			session.save(appointment);
			transaction.commit();
			return appointment;
		   }
		
		public int cancelAppointment(int appointmentId)
		   {
			initializeTransaction();
			String hql;
			int result =0;
			hql = "UPDATE APPOINTMENT SET ACTIVE = :active WHERE appointment_id = :appointmentId";
			try{
				Query query = session.createQuery(hql);
				query.setParameter(":active", false);
		    	query.setParameter(":appointmentId", appointmentId);
		    	result = query.executeUpdate();
				
			}catch(Exception e)
			{
				e.printStackTrace();
				
				
			}
			
			return result;
		   }
		
		public int updateAppointment(Appointment appointment, 
				Date appointmentDate, int appointmentId, int timeSlot, int doctorId)
		   {
			initializeTransaction();
			String hql;
			int result=0;
			hql = "UPDATE APPOINTMENT SET time_slot = :timeSlot, " +
					",appointment_date = :appointmentDate" +
					",booked_date = :currentDate" +
					" , doctor_id = :doctorId" +
					" , room_id = :roomId" +
					"WHERE appointment_id = :appointmentId";
			try{
				Query query = session.createQuery(hql);
				
				query.setParameter(":timeSlot", 60);
				query.setParameter(":appointmentDate",appointmentDate);
				query.setParameter(":currentDate",(new java.util.Date()).toString());
				query.setParameter(":doctorId", doctorId);
				query.setParameter(":roomId", 5);
		    	query.setParameter(":appointmentId", appointmentId);
		    
		    	result = query.executeUpdate();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			session.save(appointment);
			return result;
		   }
		
		public Appointment checkAppointment(Appointment appointment)
		   {
			initializeTransaction();
			session.save(appointment);
			return appointment;
		   }
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Appointment> getAppointments(User user) {
			//List obj
			//Get all active appointments
			List<Appointment> appointmentList = new ArrayList();
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			String hql;
			hql = "FROM APPOINTMENT WHERE ACTIVE = :active and user_id = :userId";
			try
			{
				Query query = session.createQuery(hql);
				query.setParameter(":active", true);
		    	  query.setParameter(":userId", user.getUserId());
		    	  appointmentList = (query.list()!=null)?(List<Appointment>) query.list() :null;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return appointmentList;
		}
		
		
		
}

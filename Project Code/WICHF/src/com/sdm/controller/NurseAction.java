package com.sdm.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdm.DAO.NurseDAO;
import com.sdm.DAO.UserDAO;
import com.sdm.model.Nurse;



public class NurseAction extends ActionSupport 
			implements ModelDriven<Nurse>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 Nurse nurse  = new Nurse();
	   List<Nurse> nurses = new ArrayList<Nurse>();
	   UserDAO userDAO = new UserDAO();
	   NurseDAO nurseDAO = new NurseDAO();
	
	public Nurse getModel() {
		return nurse;
	}
	
	 public String addNurse()
	   {
		 System.out.println("*********");
		 System.out.println(nurse.getNurseId());
		 System.out.println(nurse.getNurseName());
		 
		 
		 System.out.println(nurse.getUser().getUserId());
		 System.out.println(nurse.getUser().getPassword());
		 
		 nurse.setStatus("Active");
		 nurse.getUser().setAccessLevel("Nurse");
		 userDAO.addUser(nurse.getUser());
		 
	     nurseDAO.addNurse(nurse);
	     
	      return "success";
	   }

		

}

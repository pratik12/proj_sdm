package com.sdm.controller;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sdm.DAO.UserDAO;
import com.sdm.model.User;



public class UserAction extends ActionSupport 
			implements ModelDriven<User>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 User user  = new User();
	   List<User> users = new ArrayList<User>();
	   UserDAO userDAO = new UserDAO();
	   
	@Override
	public User getModel() {
		return user;
	}
	
	 public String addUser()
	   {
		 System.out.println("*********");
		 System.out.println(user.getUserId());
		 System.out.println(user.getPassword());
		 user.setAccessLevel("user");
	      userDAO.addUser(user);
	      return "success";
	   }

	   public String listUsers()
	   {
	      users = userDAO.getUsers();
	      return "success";
	   }


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}

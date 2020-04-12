package com.CrystalGames.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.CrystalGames.backend.dao.UserDAO;
import com.CrystalGames.backend.dto.User;
import com.CrystalGames.frontend.model.UserModel;

@ControllerAdvice
public class GlobalController 
{
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userdao;
	
	private UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		if(session.getAttribute("userModel")==null)
		{
			// add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user= userdao.getByEmail(authentication.getName());
			if(user!=null)
			{
				// create a new user model object to pass the user details
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFulName(user.getFirstname() + " " + user.getLastname());
				
				if(userModel.getRole().equals("USER"))
				{
					// set the cart only if the user is a buyer
					userModel.setCart(user.getCart());
				}
				
				// set the user model in session
				session.setAttribute("userModel",userModel);
				return userModel;
			}
			
		}
		return (UserModel) session.getAttribute("userModel");
	}
}









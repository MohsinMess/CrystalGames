package com.CrystalGames.frontend.handler;

import org.springframework.stereotype.Component;

import com.CrystalGames.backend.dto.Address;
import com.CrystalGames.backend.dto.User;
import com.CrystalGames.frontend.model.RegisterModel;

@Component
public class RegisterHandler {
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	
	
}

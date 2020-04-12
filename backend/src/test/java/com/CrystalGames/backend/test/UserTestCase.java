package com.CrystalGames.backend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.CrystalGames.backend.dao.UserDAO;
import com.CrystalGames.backend.dto.Address;
import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.User;

public class UserTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userdao;
	private User user= null;
	private Cart cart=null;
	private Address address= null;	
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.CrystalGames.backend");
		context.refresh();
		userdao= (UserDAO)context.getBean("userDAO");	
	}
	
	
	
//	  @Test 
//	  public void testAdd() {
//	  
//	  user = new User(); 
//	  user.setFirstname("Adil"); 
//	  user.setLastname("khan");
//	  user.setEmail("mmm@xyz.com"); 
//	  user.setContactnumber("12344511");
//	  user.setRole("USER"); 
//	  user.setPassword("8899"); 
//	  //add the user 
//	  assertEquals("Failed to add user!",true,userdao.addUser(user));
	  
	 	  
//	  address= new Address();
//	  address.setAddresslineone("Shaitan Nagar,Kahatarnaak galli");
//	  address.setAddresslinetwo("Bhayankar Mohalla"); address.setCity("Mumbai");
//	  address.setState("Maharashtra"); address.setCountry("India");
//	  address.setPostalcode("400052"); address.setBilling(true);
//	  
//	  // link the user using userid with the address
//	  address.setUserid(user.getId());	
//	  
//	  // add the address
//	  assertEquals("Failed to add address!",true,userdao.addAddress(address));
	  
//	  if(user.getRole().equals("USER")) { 
//		  //create a cart for the user 
//		  cart= new Cart(); 
//		  cart.setUser(user);
//		  
//		  // attach cart with user
//		  user.setCart(cart);
//		  
//		  // add the cart
//		  assertEquals("Failed to add cart!",true,userdao.updateCart(cart));
//	  }
//	 }
//}
	  
	  
	  
	  //add a shipping address
	  
//	  address= new Address();
//	  address.setAddresslineone("Shaitan Nagar,Kahatarnaak galli");
//	  address.setAddresslinetwo("Bhayankar Mohalla"); address.setCity("Mumbai");
//	  address.setState("Maharashtra"); address.setCountry("India");
//	  address.setPostalcode("400052"); address.setShipping(true);
//	  
//	  //link it with the user address.setUserid(user.getId());
//	  
//	  // add the shipping address
//	  assertEquals("Failed to add shipping address!",true,userdao.addAddress(
//	  address));
	  
//	  
//	  }
//	  
//	
//	  }
//}
	 
	
	
//	  @Test public void testAdd() {
//	  
//	  user = new User(); user.setFirstname("Ali"); user.setLastname("Ahmed");
//	  user.setEmail("abc@xyz.com"); user.setContactnumber("123456789");
//	  user.setRole("USER"); user.setPassword("123456");
//	  
//	  
//	  if(user.getRole().equals("USER")) { //create a cart for the user 
//		  cart= new Cart(); cart.setUser(user);
//	  
//	  //attach cart with the user user.setCart(cart);
//	  
//	  
//	  } //add the shipping address
//	  assertEquals("Failed to add shipping address!",true,userdao.addAddress(
//	  address));
//	  
//	  }
	 

	
	  @Test 
	  public void testUpdateCart() { 
		 // fetch the user by its eamil 
	  user=userdao.getByEmail("abc@xyz.com");
	  
	  // get the cart of the user 
	  cart= user.getCart();
	  cart.setGrandtotal(9000);
	  cart.setCartlines(2);
	  
	  assertEquals("Failed to update the cart",true,userdao.updateCart(cart));
	  
	  }
}
	
//	@Test
//	public void testAddAddress()
//	{
//		// add new user
//		
//		 user = new User(); user.setFirstname("Ali"); user.setLastname("Ahmed");
//		 user.setEmail("abc@xyz.com"); user.setContactnumber("123456789");
//		 user.setRole("USER"); user.setPassword("123456");
//		  
//		 assertEquals("Failed to add user!",true,userdao.addUser(user));
//		  
//		  
//		
//		// add new address 
//		  
//		  address= new Address();
//		  address.setAddresslineone("Shaitan Nagar,Kahatarnaak galli");
//		  address.setAddresslinetwo("Bhayankar Mohalla"); address.setCity("Mumbai");
//		  address.setState("Maharashtra"); address.setCountry("India");
//		  address.setPostalcode("400052"); address.setBilling(true);
//		  
//		  // attach user to the address
//		  address.setUser(user);
//		  
//		  // add the address
//		  assertEquals("Failed to add address!",true,userdao.addAddress(address));
//		
//		
//		// add shipping address
//		  
//		  address= new Address();
//			  address.setAddresslineone("Shaitan Nagar,Kahatarnaak galli");
//			  address.setAddresslinetwo("Bhayankar Mohalla"); address.setCity("Mumbai");
//			  address.setState("Maharashtra"); 
//			  address.setCountry("India");
//			  address.setPostalcode("400052"); 
//			  address.setShipping(true);
//			  
//			// attach user to the address
//			  address.setUser(user);
//			  
//			  // add the address
//			  assertEquals("Failed to add shipping address!",true,userdao.addAddress(address));
//			  
//			  
//		
//	}
	
//	@Test
//	public void testAddAddress()
//	{
//		user= userdao.getByEmail("abc@xyz.com");
//		
//		  address= new Address();
//		  address.setAddresslineone("nknckecn,ckenkjen");
//		  address.setAddresslinetwo("Bhayankar Mohalla"); address.setCity("Mumbai");
//		  address.setState("rashtra"); 
//		  address.setCountry("India");
//		  address.setPostalcode("400052"); 
//		  address.setShipping(true);
//		  
//		// attach user to the address
//		  address.setUser(user);
//		  
//		  // add the address
//		  assertEquals("Failed to add shipping address!",true,userdao.addAddress(address));
//	}
	
//	@Test
//	public void testGetAddresses() 
//	{
//		user= userdao.getByEmail("abc@xyz.com");
//		
//		assertEquals("Failed to fetch list of address!",2,userdao.listShippingAddresses(user).size());
//		
//		assertEquals("Failed to fetch billing address!","Maharashtra",userdao.getBillingAddress(user).getState());
//		
//	}
//	  
//	
//}








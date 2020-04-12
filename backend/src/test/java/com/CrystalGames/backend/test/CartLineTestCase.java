package com.CrystalGames.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.CrystalGames.backend.dao.CartLineDAO;
import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dao.UserDAO;
import com.CrystalGames.backend.dto.Cart;
import com.CrystalGames.backend.dto.CartLine;
import com.CrystalGames.backend.dto.Product;
import com.CrystalGames.backend.dto.User;

public class CartLineTestCase 
{
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO= null;
	private static ProductDAO productDAO= null;
	private static UserDAO userDAO=null;
	
	private Product product= null;
	private User user= null;
	private Cart cart= null;
	private CartLine cartLine=null;
	
	@BeforeClass
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.CrystalGames.backend");
		context.refresh();
		productDAO= (ProductDAO)context.getBean("productDAO");
		userDAO= (UserDAO)context.getBean("userDAO");
		cartLineDAO= (CartLineDAO)context.getBean("cartLineDAO");
		
	}
	
	@Test
	public void testAddNewCartLine() {
		
		user= userDAO.getByEmail("abc@xyz.com");
		cart= user.getCart();
		product= productDAO.get(1);
		cartLine= new CartLine();
		cartLine.setBuyingPrice(product.getUnit_price());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnit_price());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartline",true,cartLineDAO.add(cartLine));
		
		cart.setGrandtotal(cart.getGrandtotal() + cartLine.getTotal());
		cart.setCartlines(cart.getCartlines() + 1);
		
		assertEquals("Failed to update the cart",true,cartLineDAO.updateCart(cart));
	}
	
}






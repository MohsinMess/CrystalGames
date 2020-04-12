package com.CrystalGames.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CrystalGames.backend.dao.CategoryDAO;
import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dto.Category;
import com.CrystalGames.backend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	
	@RequestMapping({"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv= new ModelAndView("page");
		logger.info("Inside PageController index method-INGO");
		logger.debug("Inside PageController index method-DEBUG");
		// passing list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title","Home");
		mv.addObject("userclickhome",true);
		return mv;
		
	}
	
	@RequestMapping({"/about"})
	public ModelAndView about()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userclickabout",true);
		return mv;
	}
	
	@RequestMapping({"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userclickcontact",true);
		return mv;
	}
	
	@RequestMapping({"/show/all/products"})
	public ModelAndView showallproducts()
	{
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userclickallproducts",true);
		return mv;
		
	}
	
	@RequestMapping({"/show/category/{id}/products"})
	public ModelAndView showcategoryproducts(@PathVariable("id") int id)
	{
		ModelAndView mv= new ModelAndView("page");
		
		//Category dao to fetch  a single category
		Category category;
		category= categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		// passing list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing single category
		mv.addObject("category",category);
		mv.addObject("userclickcategoryproducts",true);
		return mv;
		
	}
	@RequestMapping({"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		
		//Update view count of the product
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);			// To display product data to be viewed 
		mv.addObject("userclickshowproduct",true);
		
		return mv;
	}
	
	// Login 
	
	@RequestMapping({"/login"})
	public ModelAndView login(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout)
	{
		ModelAndView mv= new ModelAndView("login");
		
		if(error!= null) {
			mv.addObject("message","Invalid Username or password!");
		}
		if(logout!= null) {
			mv.addObject("logout","You are now Logged Out!");
		}
		mv.addObject("title","Login");
		
		return mv;
	}
	
	
	//access denied page
	
	@RequestMapping({"/access-denied"})
	public ModelAndView accessDenied()
	{
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Caught Ya!");
		mv.addObject("errorDescription", "You Are Not Authorized to use this Page!");
		
		return mv;
		
	}
	
	// Logout
	@RequestMapping({"/perform-logout"})
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		//to fetch authenticatio object
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	// Purchased
	@RequestMapping({"/cart/add/{id}/product"})
	public ModelAndView purchase(@PathVariable int id)
	{
		ModelAndView mv= new ModelAndView("page");
		Product product = productDAO.get(id);
		mv.addObject("product",product);
		mv.addObject("title", "Item-Purchased");
		mv.addObject("userclickaddtocart",true);
		mv.addObject("note","Congratulations, your product will be delivered to your billing address!");
		
		return mv;
	}
	
	
	
	
	

}

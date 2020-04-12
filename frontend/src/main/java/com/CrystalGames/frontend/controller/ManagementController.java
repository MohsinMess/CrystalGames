package com.CrystalGames.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CrystalGames.backend.dao.CategoryDAO;
import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dto.Category;
import com.CrystalGames.backend.dto.Product;
import com.CrystalGames.util.FileUploadUtility;
import com.CrystalGames.validator.ProductValidator;


@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categorydao;
	
	@Autowired
	private ProductDAO productdao;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userclickmanageproduct",true);
		mv.addObject("title", "ManageProduct");
		Product product= new Product();
		product.setSupplierID(1);
		product.setActive(true);
		mv.addObject("product",product);
		if(operation!=null)
		{
			if(operation.equals("product")) {
				mv.addObject("message","Product Submitted successfully.");
			}
			else if(operation.equals("category")) {
				mv.addObject("meassage","Category Submitted successfully");
			}
		}
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct,BindingResult results,Model model,
			HttpServletRequest request)
	{
		new ProductValidator().validate(mproduct,results);
		
		
		// check if there are any errors
		if(results.hasErrors()) {
			
			
			model.addAttribute("userclickmanageproduct",true);
			model.addAttribute("title", "ManageProduct");
			model.addAttribute("message","Validation failed for product submission");
			
			return "page";
		}
		
		logger.info(mproduct.toString());
		
		//create  e new product record
		productdao.add(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	// to handle category submission
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		
		categorydao.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	@ModelAttribute("categories")  // will return a list of categories
	public List<Category> getCategories()
	{
		
		return categorydao.list();
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
	

}

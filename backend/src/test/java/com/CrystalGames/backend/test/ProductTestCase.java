package com.CrystalGames.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.CrystalGames.backend.dao.ProductDAO;
import com.CrystalGames.backend.dto.Product;

public class ProductTestCase 
{
	static AnnotationConfigApplicationContext context;
	Product product;
	static ProductDAO productdao;
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.CrystalGames.backend");
		context.refresh();
		
		productdao= (ProductDAO)context.getBean("productDAO");
	}
}
	
//	  @Test public void crudProduct() { product = new Product();
//	  product.setName("Playstation"); product.setBrand("Sony");
//	  product.setDescription("This is Sony Playstation");
//	  product.setUnit_price(30000); product.setActive(true);
//	  product.setCategoryID(1); product.setSupplierID(1);
//	  
//	  assertEquals("Something went wrong while adding the product",true,productdao.
//	  add(product));
//	  }
//}
//
//	 * product = productdao.get(1); product.setQuantity(2);
//	 * assertEquals("Something went wrong while updting the product",true,productdao
//	 * .update(product));
//	 * 
//	 * assertEquals("Something went wrong while deleting the product",true,
//	 * productdao.delete(product));
//	 * 
//	 * //List
//	 * assertEquals("Something went wrong while fetching the list of products",4,
//	 * productdao.list().size()); }
//	 */
	
//	@Test
//	public void testListActiveProducts()
//	{
//		assertEquals("Something went wrong while fetching the list of products",3,productdao.ListActiveProducts().size());
//	}
//	
//	@Test
//	public void testListActiveProductsByCategory()
//	{
//		assertEquals("Something went wrong while fetching the list of products",3,productdao.ListActiveProductsByCategory(1).size());
//	}
//	
//	@Test
//	public void testLatestListActiveProductsByCategory()
//	{
//		assertEquals("Something went wrong while fetching the list of products",3,productdao.ListLatestActiveProducts(3).size());
//	}
//}
















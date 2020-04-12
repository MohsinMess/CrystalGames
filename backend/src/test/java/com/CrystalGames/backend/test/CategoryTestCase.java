package com.CrystalGames.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.CrystalGames.backend.dao.CategoryDAO;
import com.CrystalGames.backend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categorydao;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.CrystalGames.backend");
		context.refresh();

		categorydao = (CategoryDAO) context.getBean("categoryDAO"); // bean name should be the same as the repository.
	}

	/*
	 * @Test public void testAddCategory() { category= new Category();
	 * category.setName("Playstation"); category.setDescription("Sony");
	 * category.setImageURL("img.png");
	 * 
	 * assertEquals("Added a category to the table",true,categorydao.add(category));
	 * }
	 */

	/*
	 * @Test public void getCategory() { category= categorydao.get(1);
	 * assertEquals("Fetched a single category from the table","Playstation",
	 * category.getName()); }
	 */

	/*
	 * @Test public void updateCategory() { category= categorydao.get(2); //
	 * Fetching the category category.setName("XBOX"); //Setting new name
	 * assertEquals("Category name has been updated",true,categorydao.update(
	 * category)); //Checking if it has been updated or not }
	 */

	/*
	 * @Test public void deleteCategory() { category =categorydao.get(3);
	 * assertEquals("Selected Category has been deleted",true,categorydao.delete(
	 * category));
	 * 
	 * }
	 */

	/*
	 * @Test public void listCategory() {
	 * assertEquals("List of categories fetched",2,categorydao.list().size()); }
	 */

	@Test
	public void crudCatgory() {
		category = new Category();
		category.setName("Wii");
		category.setDescription("Description for Wii");
		category.setImageURL("imageURL");
		assertEquals("Category has been added to the table", true, categorydao.add(category));
		
		category = new Category();
		category.setName("Wii");
		category.setDescription("Description for Wii");
		category.setImageURL("imageURL");
		assertEquals("Category has been added to the table", true, categorydao.add(category));
		
		category = new Category();
		category.setName("Wii");
		category.setDescription("Description for Wii");
		category.setImageURL("imageURL");
		assertEquals("Category has been added to the table", true, categorydao.add(category));

		 
		category= categorydao.get(3); 		//Fetching the category category.setName("XBOX");
		category.setName("Nintendo");		//Setting new name
		assertEquals("Category name has been updated",true,categorydao.update(category)); //Checking if it has been updated or not 
		
		category =categorydao.get(2);
		assertEquals("Selected Category has been deleted",true,categorydao.delete(category));
		
		assertEquals("List of categories fetched",2,categorydao.list().size());
		 
		 

	}

}

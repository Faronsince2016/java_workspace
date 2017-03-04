package com.bjsxt.bbs2009.action;

import java.util.List;

import com.bjsxt.bbs2009.model.Category;
import com.bjsxt.bbs2009.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private List<Category> categories;   //这个List需不需要get set？   为了在前台页面中访问。必须要
	private CategoryService categoryService = new CategoryService(); 
	private Category category;           //可以每次new一个对象  每次传category.id   就是麻烦
	private int id; //设置id属性    传参数的时候传入id就可以了  不用传入category.id
	
	public String list() throws Exception {
		categories = categoryService.list();   //不用new   使用list的时候就new了
		return SUCCESS;
	}
	
	
	
	public String add() {
		categoryService.add(category);
		return SUCCESS;
	}
	public String update() {
		categoryService.update(category);
		return SUCCESS;
	}
	public String delete() {
		categoryService.deleteById(id);
		return SUCCESS;
	}
	public String addInput() {
		
		return INPUT;
	}
	public String updateInput() {
		this.category = this.categoryService.loadById(id);
		return INPUT;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

package com.myclass.dto;

import java.util.List;

import com.myclass.entity.Product;
import com.myclass.entity.User;

public class BillDto {
	
	private List<Product> products;
	private List<User> users;
	
	public BillDto() {
		// TODO Auto-generated constructor stub
	}

	public BillDto(List<Product> products, List<User> users) {
		super();
		this.products = products;
		this.users = users;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "BillDto [products=" + products + ", users=" + users + "]";
	}
	
	
	


}

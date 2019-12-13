package com.myclass.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Product;
import com.myclass.repository.ProductRepository;
import com.myclass.repository.StatusRepository;

@Controller
@RequestMapping("admin/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StatusRepository statusRepository;

	@GetMapping("")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();

		model.addAttribute("products", products);
		return "product/index";
	}

	@GetMapping("add")
	public String add(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("status", statusRepository.findAll());

		return "product/add";
	}

	@PostMapping("add")
	public String add(Model model, @Valid @ModelAttribute("product") Product product, BindingResult errors) {
		// Kiểm tra nhập liệu
		if (errors.hasErrors()) {

			model.addAttribute("status", statusRepository.findAll());
			return "product/add";
		}
		
		
		Date now= new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	   
		try {
			product.setDateProduct(formatter.parse(formatter.format(now)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(product.toString());
		productRepository.save(product);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/product";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		System.out.println("ID BEFORE: " + id);
		// model.addAttribute("id", id);
		model.addAttribute("product", productRepository.findById(id));
		model.addAttribute("status", statusRepository.findAll());
		return "product/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("product") Product product, BindingResult errors) {
		// Bắt lỗi nhập liệu
		if (errors.hasErrors()) {
			System.out.println("ERROR");
			model.addAttribute("status", statusRepository.findAll());
			return "product/edit";
		}
		System.out.println("ID AFTER: " + product.getId());
		// Cập nhật
		Date now= new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	   
		try {
			product.setDateProduct(formatter.parse(formatter.format(now)));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		product.setQuantity(1);
		product.setBeverage(false);
		//product.setStatus(statusRepository.findById(product.getStatusId()).get());

		// product.setDateProduct(new Date());
		System.out.println(product.toString());
		productRepository.save(product);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/product";

	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		// Xóa User theo id
		productRepository.deleteById(id);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/product";
	}
}

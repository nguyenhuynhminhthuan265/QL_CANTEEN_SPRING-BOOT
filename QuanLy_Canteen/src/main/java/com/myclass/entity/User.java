package com.myclass.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Vui lòng nhập email!")
	@Email(message = "Email không đúng định dạng!")
	private String email;

	@NotBlank(message = "Vui lòng nhập họ tên!")
	private String name;

	// @NotBlank(message = "Vui lòng nhập mật khẩu!")
	@Length(min = 6, message = "Mật khẩu từ min 6 ký tự!")
	private String password;
	private String address;
	private String phone;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.REFRESH,
			CascadeType.PERSIST })
	private List<Bill> bills;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id,
			@NotBlank(message = "Vui lòng nhập email!") @Email(message = "Email không đúng định dạng!") String email,
			@NotBlank(message = "Vui lòng nhập họ tên!") String name,
			@Length(min = 6, message = "Mật khẩu từ min 6 ký tự!") String password, String address, String phone,
			List<Bill> bills) {

		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.bills = bills;
	}

	public User(
			@NotBlank(message = "Vui lòng nhập email!") @Email(message = "Email không đúng định dạng!") String email,
			@NotBlank(message = "Vui lòng nhập họ tên!") String name,
			@Length(min = 6, message = "Mật khẩu từ min 6 ký tự!") String password, String address, String phone,
			List<Bill> bills) {

		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.bills = bills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

}

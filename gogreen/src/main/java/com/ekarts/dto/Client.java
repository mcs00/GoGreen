package com.ekarts.dto;

import java.io.Serializable;

public class Client implements Serializable{   
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private double balance;

    public Client() {
    }

	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String name, String surname, String email, String phone, double balance) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
	}

	public Client(String name, String surname, String email, String phone, double balance) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
				+ ", balance=" + balance + "]";
	}



}

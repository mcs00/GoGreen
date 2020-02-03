package com.gogreen.dto;

import java.io.Serializable;

public class Product implements Serializable{   
    private int code;
    private String name;
    private Double price;
    private int weight;
    private String description;
    private Double saldo;

	public Product(int code) {
		this.code = code;
	}

	public Product(int code, String name, Double price, int weight, String description, Double saldo) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.saldo = saldo;
	}

	public Product(String name2, String price2, String weight2, String description2, double saldo2) {
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setPhone(String description) {
		this.description = description;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Client [id=" + code + ", name=" + name + ", price=" + price + ", weight=" + weight + ", description=" + description + ", saldo=" + saldo + "]";
	}

	public void setDescription(String description2) {
		// TODO Auto-generated method stub
		
	}



}

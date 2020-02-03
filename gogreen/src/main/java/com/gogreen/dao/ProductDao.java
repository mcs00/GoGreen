package com.gogreen.dao;

import java.sql.*;
import java.util.*;


import com.gogreen.dto.Product;

public class ProductDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */
	public List<Product> listar() {
		String SQL_SELECT = "SELECT pro_code, pro_name, pro_price, pro_weight, pro_description " + " FROM products";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt("pro_code");
				String name = rs.getString("cli_name");
				Double price = rs.getDouble("pro_price");
				Integer weight = rs.getInt("pro_weight");
				String description = rs.getString("pro_description");
				Double saldo = rs.getDouble("pro_saldo");

				product = new Product(code, name, price, weight, description, saldo);
				products.add(product);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return products;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	public Product findById(Product product) {
		String SQL_SELECT_BY_ID = "SELECT pro_code, pro_name, pro_price, pro_weight, pro_description "
				+ " FROM products WHERE pro_code = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, product.getCode());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("pro_name");
			Double price = rs.getDouble("pro_price");
			Integer weight = rs.getInt("pro_weight");
			String description = rs.getString("pro_description");

			product.setName(name);
			product.setPrice(price);
			product.setWeight(weight);
			product.setDescription(description);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return product;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	public int create(Product product) {
		String SQL_INSERT = "INSERT INTO client(pro_code, pro_name, pro_price, pro_weight, pro_description) "
				+ " VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getWeight());
			stmt.setString(4, product.getDescription());
System.out.println(product.toString());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un client de la base de dades
	 * 
	 */
	public int update(Product product) {
		String SQL_UPDATE = "UPDATE client "
				+ " SET pro_name=?, pro_price=?, pro_weight=?, pro_description=?, WHERE pro_code=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, product.getName());
			stmt.setDouble(i++, product.getPrice());
			stmt.setInt(i++, product.getWeight());
			stmt.setString(i++, product.getDescription());
			stmt.setInt(i++, product.getCode());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Esborra un producte de la base de dades
	 * 
	 */
	public int delete(Product product) {
		String SQL_DELETE = "DELETE FROM product WHERE pro_code = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, product.getCode());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	public Product findByCode(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}

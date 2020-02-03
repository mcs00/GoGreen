package com.gogreen.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.gogreen.dao.ProductDao;
import com.gogreen.dto.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	
private static final long serialVersionUID = -7558166539389234332L;
	   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.deleteProduct(request, response);
				break;
			default:
				this.showListProduct(request, response);
			}
		} else {
			this.showListProduct(request, response);
		}
	}

	private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				this.deleteProduct(request, response);
				break;
			case "insert":
				this.insertProduct(request, response);
				break;
			case "update":
				this.updateProduct(request, response);
				break;
			default:
				this.showListProduct(request, response);
			}
		} else {
			this.showListProduct(request, response);
		}
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showListProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ProductDao().listar();

		System.out.println("products = " + products);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		session.setAttribute("totalProductos", products.size());
		session.setAttribute("saldoTotal", this.calcularSaldoTotal(products));

		// request.getRequestDispatcher("frmProduct.jsp").forward(request, response);
		response.sendRedirect("frmProduct.jsp");
	}

	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idProduct
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		Product product = new ProductDao().findById(new Product(codeProduct));
		request.setAttribute("product", product);
		String jspEditar = "/editProduct.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}

	private void insertProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarProducto
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		Double precio = Double.parseDouble(price);
		String weight = request.getParameter("weight");
		Integer weightt = Integer.parseInt(weight);
		String description = request.getParameter("descripcion");
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}

		// Creamos el objeto de producto (modelo)
		Product product = new Product(name, price, weight, description, saldo);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new ProductDao().create(product);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListProduct(request, response);
	}

	private void updateProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar producto");
		
		// Recuperam els valors del formulari editProduct
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		String name = request.getParameter("nombre");
		System.out.println("Nombre:" + name);
		
		String price = request.getParameter("price");
		Double precio = Double.parseDouble(price);
		String weight = request.getParameter("weight");
		Integer weightt = Integer.parseInt(weight);
		String description = request.getParameter("description");
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}

		// Creamos el objeto de producto (modelo)
		Product product = new Product(name, price, weight, description, saldo);

		// Modificar el objeto en la base de datos
		int registrosModificados = new ProductDao().update(product);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListProduct(request, response);
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarProducto
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));

		// Creamos el objeto de producto (modelo)
		Product product = new Product(codeProduct);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new ProductDao().delete(product);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListProduct(request, response);
	}
	
	private double calcularSaldoTotal(List<Product> products) {
		double saldoTotal = 0;
		for (Product product : products) {
			saldoTotal += product.getPrice();
		}
		return saldoTotal;
	}

}

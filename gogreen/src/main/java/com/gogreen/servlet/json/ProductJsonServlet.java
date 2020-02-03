package com.gogreen.servlet.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gogreen.dao.ProductDao;
import com.gogreen.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet({ "/product.json", "/listProducts.json" })
public class ProductJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductJsonServlet() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sCode = request.getParameter("code");
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		
		if (servletPath.equals("/product.json")) {
			if (sCode!=null) {
				int code = Integer.parseInt(sCode);
				Product product = new ProductDao().findByCode(new Product(code));;
				
				ObjectMapper mapper = new ObjectMapper(); 
				String jsonResult = mapper.writeValueAsString(product);
				
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(jsonResult);
				out.flush();
			}else {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print("{error:'id no trobat'}");
				out.flush();
			}

		}else if (servletPath.equals("/listProducts.json")){
			List<Product> products = new ProductDao().listar();
			
			ObjectMapper mapper = new ObjectMapper(); 
			String jsonResult = mapper.writeValueAsString(products);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonResult);
			out.flush();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
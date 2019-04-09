package cn.hw.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hw.oa.service.Productservice;
import model.Product;

//只有继承了HttpServlet，就可以接收http请求(get,post)
//@开头的是注解，用来标识访问当前servlet类的地址
@WebServlet("/Productservlet")
public class Productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Productservice productService = new Productservice();

	/*
	 * public Productservlet() { super(); }
	 */
	// doGet请求只能处理get请求
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	// doPost请求只能处理Post请求
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		if (type.equals("save")) {

			Product product = new Product();
			product.setName(request.getParameter("name"));
			String price = request.getParameter("price");
			product.setPrice(Double.parseDouble(price));
			product.setRemark(request.getParameter("remark"));
			productService.save(product);
			response.sendRedirect("/wed/query.jsp");

		} else if (type.equals("query")) {
			String keyword = request.getParameter("keyword");
			List<Product> arraylist = productService.queryByName(keyword);
			request.setAttribute("arraylist", arraylist);
			// 请求的转发，系统默认添加工程名
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/query.jsp");
			// 在转发过程中传递之前的request请求
			requestDispatcher.forward(request, response);

		} else if (type.equals("delete")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			productService.delete(pid);
		} else if (type.equals("getById")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Product product=productService.getById(id);
			request.setAttribute("product", product);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/update.jsp");
			requestDispatcher.forward(request, response);
		}else if (type.equals("update")) {
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setId(Integer.parseInt(request.getParameter("id")));
			String price = request.getParameter("price");
			product.setPrice(Double.parseDouble(price));
			product.setRemark(request.getParameter("remark"));
			productService.update(product);
			response.sendRedirect(request.getContextPath() + "/query.jsp");;
		}
		else {
			
		}
	}
}

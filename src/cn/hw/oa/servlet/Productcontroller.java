package cn.hw.oa.servlet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hw.oa.service.Productservice;
import model.Product;
@RequestMapping("/product")
@Controller
public class Productcontroller {
	@Resource
	private HttpServletRequest request;
	@Resource(name = "ps") // spring-bean.xml中id为ps的类
	private Productservice productService;

	@RequestMapping("/save")
	public String save(Product product) {
		System.out.println(product);
		productService.save(product);
		return "redirect:/query.jsp";
	}
	@RequestMapping("/delete")
	public void delete(int pid) {
		productService.delete(pid);
	}
	@RequestMapping("/getById")
	public String getById (int id) {
		Product product = productService.getById(id);	
		request.setAttribute("product", product);
		return "forward:/update.jsp";	
	}
	@RequestMapping("/query")
		public String queryByName(String keyword) {
			List<Product> proList = productService.queryByName(keyword);
			request.setAttribute("proList", proList);
			return "forward:/query.jsp";
	}
	@RequestMapping("/update")
	public String update(Product product) {
		productService.update(product);
		return "redirect:/query.jsp";
	}
}

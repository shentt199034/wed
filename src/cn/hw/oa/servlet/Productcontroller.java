package cn.hw.oa.servlet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hw.oa.service.Productservice;
import model.Product;
@RequestMapping("/product")
@Controller
public class Productcontroller {
	@Resource(name = "ps") // spring-bean.xml中id为ps的类
	private Productservice productService;

	@RequestMapping("/save")
	public String save(Product product) {
		System.out.println(product);
		productService.save(product);
		return "redirect:/query.jsp";
	}

	
}

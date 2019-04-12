package cn.hw.oa.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;

import cn.hw.oa.service.Categoryservice;
import cn.hw.oa.service.Productservice;
import model.Category;
import model.Product;

@Controller
public class InitController {
	@Resource
	private Productservice productService;
	@Resource
	private Categoryservice categoryService;
	@Resource // 代表当前app，全局唯一，项目启动时存在，项目关闭时销毁
	private ServletContext application;
	@PostConstruct
	public void initData() {
		// 0: 创建一个用来存储集合的集合
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		// 1: 查询热点类别
		List<Category> catList = categoryService.queryHot(true);
		for (Category temp : catList) {
			// 2: 根据热点类别ID查询推荐商品
			List<Product> proList = productService.queryByCid(temp.getCid());
			bigList.add(proList);
		}
		application.setAttribute("bigList", bigList);
	}
}

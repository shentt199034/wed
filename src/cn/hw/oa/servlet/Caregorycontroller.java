package cn.hw.oa.servlet;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hw.oa.service.Categoryservice;
import model.Category;
import model.Product;
@RequestMapping("/category")
@Controller
public class Caregorycontroller {
	// 完成查询所有类别,因此需要依赖CategoryService
		@Resource(name = "cs") // 去spring-bean.xml中查找id=cs的类
		private Categoryservice categoryService;

		// 创建一个方法,用来查询所有的类别数据,返回的是JSON格式
		@RequestMapping("queryAll")
		@ResponseBody // 响应不在时页面,而是数据此注解可以把返回的对象转化为json格式
		public Object queryAll() {
			List<Category> catList = categoryService.queryByName("");
			System.out.println(catList);
			// 此处不应该保存在request中,而是返回为json格式(需要导入json包)
			return catList;

		}

}

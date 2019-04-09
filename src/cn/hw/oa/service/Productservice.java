package cn.hw.oa.service;
//业务逻辑层（JAVA类），以后添加购物车的业务逻辑层
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hw.oa.dao.Productdao;
import model.Product;

public class Productservice {
//执行完业务逻辑才调用数据访问层入库
	private Productdao productdao=null;
	public void setProductdao(Productdao productdao) {
		this.productdao = productdao;
	}
	public void save (Product product) {
		productdao.save(product);
	}
	public void delete (int id) {
		productdao.delete(id);
	}
	public void update (Product product) {
		productdao.update(product);
	}
	public Product getById (int id) {
		return productdao.getById(id);
	}
	public List<Product> queryByName(String name) {
		return productdao.queryByName(name);
	}
	public static void main(String[] args) {
		// new的对象并不是通过spring框架创建,因此没有依赖注入的功能, 因此只能通过Spring创建
		// ProductDao productDao = new ProductDao();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		// 通过id获取相应的类型，并且创建对象(通过spring配置的bean才拥有依赖注入的功能)
		Productservice productservice = context.getBean("ps", Productservice.class);
		// 项目中所有的model不需要交给spring管理,因为这些值是从前端传入,而且是多例模式
		Product product = new Product();
		product.setName("xyz");
		productservice.save(product);
		List<Product> prolist=productservice.queryByName("");
		for(Product temp : prolist) {
			System.out.println(temp);
		}
		
		}
 
	}

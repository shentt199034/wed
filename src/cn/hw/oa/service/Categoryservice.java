package cn.hw.oa.service;
//业务逻辑层（JAVA类），以后添加购物车的业务逻辑层
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hw.oa.dao.Categorydao;
import model.Category;

public class Categoryservice {
//执行完业务逻辑才调用数据访问层入库
	private Categorydao categorydao = null;
public void setCategorydao(Categorydao categorydao) {
	this.categorydao = categorydao;
}
	public void save (Category category) {
		categorydao.save(category);
	}
	public void delete (int id) {
		categorydao.delete(id);
	}
	public void update (Category category) {
		categorydao.update(category);
	}
	public Category getById (int id) {
		return categorydao.getById(id);
	}
	public List<Category> queryByName(String name) {
		return categorydao.queryByName(name);
	}
	public static void main(String[] args) {
		// new的对象并不是通过spring框架创建,因此没有依赖注入的功能, 因此只能通过Spring创建
		// ProductDao productDao = new ProductDao();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		// 通过id获取相应的类型，并且创建对象(通过spring配置的bean才拥有依赖注入的功能)
		Categoryservice categoryservice = context.getBean("cs", Categoryservice.class);
		// 项目中所有的model不需要交给spring管理,因为这些值是从前端传入,而且是多例模式
  //  	Category category = new Category();
//		category.setName("玩具");
//		categoryservice.save(category);
//		List<Category> categorylist=categoryservice.queryByName("");
//		for(Category temp : categorylist) {
//			System.out.println(temp);
//		}
		List<Category> categorylist=categoryservice.queryByName("");
		for(Category temp : categorylist) {
			System.out.println(temp);
		}
		}
 
	}

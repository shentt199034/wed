package cn.hw.oa.service;
//业务逻辑层（JAVA类），以后添加购物车的业务逻辑层
import java.util.List;

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
	public List<Category> queryHot(boolean isHot) {
		return categorydao.queryHot(isHot);
	}
	
	}

package cn.hw.oa.service;
//业务逻辑层（JAVA类），以后添加购物车的业务逻辑层

import java.util.ArrayList;


import cn.hw.oa.dao.Productdao;
import model.Product;

public class Productservice {
//执行完业务逻辑才调用数据访问层入库
	private Productdao productdao=new Productdao();
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
	public ArrayList<Product> queryByName(String name) {
		return productdao.queryByName(name);
	}
 
	}

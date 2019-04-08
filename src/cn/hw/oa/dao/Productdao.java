package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;


public class Productdao extends BaseDao{
	public void save(Product product) {
		String sql="insert into product(name,price,remark) value(?,?,?)";
		super.update(sql,  new Object[] {product.getName(),product.getPrice(),product.getRemark() });
	
	}

	public Product getById(int id) {
		Connection conn = JdbcUtils.getConnection();
		try {
			PreparedStatement pre = conn.prepareStatement("select * from product where id = ?");
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			Product product = null;
			if (rs.next()) {
			    product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
			}
			return product;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			System.out.println("关闭");
			JdbcUtils.close(conn);
		}
	}
	public ArrayList<Product> queryByName(String name) {
		Connection conn = JdbcUtils.getConnection();
		try {
			PreparedStatement pre = conn.prepareStatement("select * from product where name like ?");
			pre.setString(1, "%"+name+"%");
			ResultSet rs = pre.executeQuery();
			ArrayList<Product> prolist = new ArrayList<Product>();
			while (rs.next()) {
				Product product =new Product();
				//product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				prolist.add(product);
			}
			return prolist;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			System.out.println("关闭");
			JdbcUtils.close(conn);
		}
	}

	public void delete(int id) {
	String sql="delete from product where id = ?";
	super.update(sql, new Object[] {id});
	}
	public void update(Product product) {
		String sql="update product set name=?,price=?,remark=? where id=?";
		super.update(sql,  new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId() });
	}


	public static void main(String[] args) {
		Productdao dao1 = new Productdao();
		Productdao dao2 = new Productdao();
		Product product = new Product();
		product.setName("华为手机");
		product.setPrice(6999);
		product.setRemark("测试成功");
		product.setId(17);
		dao1.save(product);
		dao2.delete(2);
		dao1.update(product);
		System.out.println(dao1.getById(2));
		ArrayList<Product> prolist = dao1.queryByName("西服");
		for(Product temp:prolist){
			System.out.println(temp);
		}
		// dao1.delete(product);

	}
}

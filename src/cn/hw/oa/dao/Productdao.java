package cn.hw.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Category;
import model.Product;


public class Productdao{
	
	private JdbcTemplate jdbcTemplate;
	
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void save(Product product) {
		String sql="insert into product(name,price,remark,cid) value(?,?,?,?)";
		jdbcTemplate.update(sql,  new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getCategory().getCid() });
	
	}

	public Product getById(int id) {
		String sql="select * from product where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				return product;
			}
			});

	}
	public List<Product> queryByCid(int cid) {
		String sql = "select * from product p join category c on p.cid = c.cid where p.cid = ? limit 0,4";
		return jdbcTemplate.query(sql, new Object[] { cid }, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				// // 则说明查询结果有记录,应该创建一个对象来保存当前记录
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setRemark(rs.getString("remark"));
				product.setPrice(rs.getDouble("price"));
				product.setDate(rs.getDate("date"));
				// 还需要创建一个类别对象
				Category cagegory = new Category();
				cagegory.setCid(rs.getInt("cid"));
				cagegory.setCname(rs.getString("cname"));
				cagegory.setChot(rs.getBoolean("chot"));
				// 吧类别添加到商品对象中
				product.setCategory(cagegory);
				return product;
			}

		});
	}
	public List<Product> queryByName(String name) {
		String sql="select * from product p join category c on p.cid=c.cid where p.name like ?";
        return jdbcTemplate.query(sql,new Object[] {"%"+name+"%"}, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				product.setDate(rs.getDate("date"));
				Category category=new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				product.setCategory(category);
				return product;
			}
        	
        });
	}

	public void delete(int id) {
	String sql="delete from product where id = ?";
	jdbcTemplate.update(sql, new Object[] {id});
	}
	public void update(Product product) {
		String sql="update product set name=?,price=?,remark=? where id=?";
		jdbcTemplate.update(sql,  new Object[] {product.getName(),product.getPrice(),product.getRemark(),product.getId() });
	}
}




package cn.hw.oa.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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


	public static void main(String[] args) {
		// new的对象并不是通过spring框架创建,因此没有依赖注入的功能, 因此只能通过Spring创建
		// ProductDao productDao = new ProductDao();
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		// 通过id获取相应的类型，并且创建对象(通过spring配置的bean才拥有依赖注入的功能)
		Productdao productdao = context.getBean("pd", Productdao.class);
		// 项目中所有的model不需要交给spring管理,因为这些值是从前端传入,而且是多例模式
		Product product = new Product();

		product.setName("iphone8");
		product.setPrice(7000);
		product.setRemark("插入商品时测试类别CID");
		Category category = new Category();
		category.setCid(2);
		product.setCategory(category);
		productdao.save(product);
		List<Product> prolist=productdao.queryByName("");
	    for(Product temp : prolist) {
			System.out.println(temp);
		}
//		System.out.println(productdao.getById(3));
		
		}
		// dao1.delete(product);

	}


package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Category;
import model.Product;


public class Categorydao{
	
	private JdbcTemplate jdbcTemplate;
	
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void save(Category category) {
		String sql="insert into category(name) value(?)";
		jdbcTemplate.update(sql,  new Object[] {category.getCname()});
	
	}
	public Category getById(int id) {
		String sql="select * from category where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Category >() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Category category  = new Category();
				category.setCid(rs.getInt("id"));
				category.setCname(rs.getString("name"));
				return category;
			}
			});

	}
	public List<Category> queryByName(String name) {
		String sql="select * from category where name like ?";
        return jdbcTemplate.query(sql,new Object[] {"%"+name+"%"}, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category  = new Category();
				category .setCid(rs.getInt("id"));
				category .setCname(rs.getString("name"));
				return category;
			}
        	
        });
	}

	public void delete(int id) {
	String sql="delete from category where id = ?";
	jdbcTemplate.update(sql, new Object[] {id});
	}
	public void update(Category category) {
		String sql="update category set name=? where id=?";
		jdbcTemplate.update(sql,  new Object[] {category.getCname(),category.getCid() });
	}
}


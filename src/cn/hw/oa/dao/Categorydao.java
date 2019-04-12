package cn.hw.oa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Category;


public class Categorydao{
	
	private JdbcTemplate jdbcTemplate;
	
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void save(Category category) {
		String sql="insert into category(cname) value(?)";
		jdbcTemplate.update(sql,  new Object[] {category.getCname()});
	
	}
	public Category getById(int id) {
		String sql="select * from category where cid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Category >() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Category category  = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				return category;
			}
			});

	}
	public List<Category> queryByName(String name) {
		String sql="select * from category where cname like ?";
        return jdbcTemplate.query(sql,new Object[] {"%"+name+"%"}, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category category  = new Category();
				category .setCid(rs.getInt("cid"));
				category .setCname(rs.getString("cname"));
				return category;
			}
        	
        });
	}
	public List<Category> queryHot(boolean isHot) {
		String sql = "select * from category where chot = ?";
		return jdbcTemplate.query(sql, new Object[] { isHot }, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				Category category = new Category();
				// // 则说明查询结果有记录,应该创建一个对象来保存当前记录
				category.setCid(rs.getInt("cid"));
				category.setCname(rs.getString("cname"));
				category.setChot(rs.getBoolean("chot"));
				return category;
			}

		});
	}

	public void delete(int id) {
	String sql="delete from category where cid = ?";
	jdbcTemplate.update(sql, new Object[] {id});
	}
	public void update(Category category) {
		String sql="update category set cname=? where cid=?";
		jdbcTemplate.update(sql,  new Object[] {category.getCname(),category.getCid() });
	}
}


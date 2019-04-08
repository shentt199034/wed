package cn.hw.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
    protected void update(String sql,Object[] params) {

		Connection conn = JdbcUtils.getConnection();
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				pre.setObject(i+1, params[i]);
			}
			pre.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.close(conn);
		}
	
	}
}

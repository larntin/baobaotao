package com.dengdongdong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.dengdongdong.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMactchCount(String userName, String password) {
		String sqlStr = String.format(" SELECT count(*) FROM t_user WHERE user_name = '%1$s' and pwd = '%2$s' ", userName, password);
		int result = jdbcTemplate.queryForObject(sqlStr, int.class);
		return result;
	}
	
	public User findUserByUserName(final String userName) {
		String sqlStr = " SELECT user_id,user_name,credits "
				+ " FROM t_user WHERE user_name =? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName },
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
					}
				});
		return user;
	}

	public void updateLoginInfo(User user) {
		String sqlStr = " UPDATE t_user SET last_visit=?,last_ip=?,credits=? "
				+ " WHERE user_id =?";
		jdbcTemplate.update(sqlStr, new Object[] { user.getLastVisit(),
				user.getLastIp(),user.getCredits(),user.getUserId()});
	}
}

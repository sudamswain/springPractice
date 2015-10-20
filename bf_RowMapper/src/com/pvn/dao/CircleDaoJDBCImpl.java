package com.pvn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

@Component
public class CircleDaoJDBCImpl
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public int getCircleCount()
	{
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleNameForCircleId(int circleId)
	{
		String sql="SELECT NAME FROM CIRCLE WHERE CIRCLE_ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	public Circle getCircleForCircleId(int circleId)
	{
		String sql="SELECT * FROM CIRCLE WHERE CIRCLE_ID=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	public List<Circle> getAllCirclesAsList()
	{
		String sql="SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public List<Circle> getLimitedCirclesAsList(int maxRows)
	{
		String sql="SELECT * FROM CIRCLE";
		jdbcTemplate.setMaxRows(maxRows);
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public static class CircleMapper implements RowMapper<Circle>
	{

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException 
		{
			Circle circle=new Circle();
			circle.setCircleId(resultSet.getInt("circle_id"));
			circle.setName(resultSet.getString("name"));
			return circle;
		}
		
	}
}

	

package com.pvn.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

@Component
public class CircleDaoJdbcImpl 
{
	private BasicDataSource dataSource;
	private SimpleJdbcTemplate simpleJdbcTemplate;

	public void inserIntoCircle(Circle circle)
	{
		String sql="INSERT INTO CIRCLE (CIRCLE_ID,NAME) VALUES(:id,:name)";
		SqlParameterSource sqlParamSource=new MapSqlParameterSource()
											.addValue("id", circle.getCircleId())
											.addValue("name", circle.getName());
		simpleJdbcTemplate.update(sql, sqlParamSource);
	}
	
	public int getCirclesCount()
	{
		String sql="select count(*) from circle";
		return simpleJdbcTemplate.queryForInt(sql,new MapSqlParameterSource());
	}
	
	@Autowired
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
		this.simpleJdbcTemplate=new SimpleJdbcTemplate(dataSource);
	}
}

package com.pvn.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.pvn.model.Circle;

public class CircleDaoJdbcImpl extends SimpleJdbcDaoSupport 
{
	public void inserIntoCircle(Circle circle)
	{
		String sql="INSERT INTO CIRCLE (CIRCLE_ID,NAME) VALUES(:id,:name)";
		SqlParameterSource sqlParamSource=new MapSqlParameterSource()
											.addValue("id", circle.getCircleId())
											.addValue("name", circle.getName());
		this.getSimpleJdbcTemplate().update(sql, sqlParamSource);
	}
	
	public int getCirclesCount()
	{
		System.out.println("Data source used : "+this.getDataSource().getClass());
		String sql="select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}

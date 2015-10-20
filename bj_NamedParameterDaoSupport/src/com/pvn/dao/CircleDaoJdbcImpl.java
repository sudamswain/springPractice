package com.pvn.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.pvn.model.Circle;

public class CircleDaoJdbcImpl extends NamedParameterJdbcDaoSupport 
{
	public void inserIntoCircle(Circle circle)
	{
		String sql="INSERT INTO CIRCLE (CIRCLE_ID,NAME) VALUES(:id,:name)";
		SqlParameterSource sqlParamSource=new MapSqlParameterSource()
											.addValue("id", circle.getCircleId())
											.addValue("name", circle.getName());
		this.getNamedParameterJdbcTemplate().update(sql, sqlParamSource);
	}
	
	public int getCirclesCount()
	{
		System.out.println("Data source used : "+this.getDataSource().getClass());
		String sql="select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}

package com.pvn.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import com.pvn.model.Circle;

public class CircleDaoJdbcImpl extends NamedParameterJdbcDaoSupport 
{
	public int getCirclesCount()
	{
		System.out.println("Data source used : "+this.getDataSource().getClass());
		String sql="select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
	
	public List<Circle> getAllCircles()
	{
		String sql="select circle_id as circleId,name from circle";
		return this.getJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(Circle.class));
	}
}

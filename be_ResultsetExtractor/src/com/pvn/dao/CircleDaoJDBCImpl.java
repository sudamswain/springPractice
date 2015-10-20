package com.pvn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

@Component
public class CircleDaoJDBCImpl
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	public int getCircleCount()
	{
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public List<Circle> getAllCirclesAsListReseultSetExtractor()
	{
		String sql="SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleRSExtractor());
	}
	
	public static class CircleRSExtractor implements ResultSetExtractor<List<Circle>>
	{
		@Override
		public List<Circle> extractData(ResultSet rs) throws SQLException,
		DataAccessException 
		{
			List<Circle> circles=new ArrayList<>();
			while(rs.next())
			{
				Circle circle=new Circle();
				circle.setCircleId(rs.getInt("circle_id"));
				circle.setName(rs.getString("name"));
				circles.add(circle);
			}
			return circles;
		}
	}
	
}

	

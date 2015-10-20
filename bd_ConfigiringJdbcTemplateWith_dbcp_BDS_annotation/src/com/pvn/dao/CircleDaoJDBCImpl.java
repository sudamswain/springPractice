package com.pvn.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pvn.model.Circle;

@Component
public class CircleDaoJDBCImpl
{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public Circle getCircle(int circleId) 
	{
		Connection con=null;
		try
		{
			con=dataSource.getConnection();
		    PreparedStatement pstmt=con.prepareStatement("select * from circle where circle_id= ?");
		    pstmt.setInt(1, circleId);
		    ResultSet rs=pstmt.executeQuery();
		    Circle circle =null;
		    if(rs.next())
		    {
		    	circle =new Circle(circleId, rs.getString("name"));
		    }
		    rs.close();
		    pstmt.close();
			return circle;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally
		{
			try 
			{
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public int getCircleCount()
	{
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	
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
}

	

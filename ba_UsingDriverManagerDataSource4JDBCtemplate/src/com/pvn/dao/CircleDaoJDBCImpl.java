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

//@Component   //configured in spring.xml
public class CircleDaoJDBCImpl
{
//	@Autowired   // autowired in xml
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Circle getCircle(int circleId) 
	{
		Connection con=null;
		try
		{
			/*
			 *Removed because dataSource is wired with org.springframework.jdbc.datasource.DriverManagerDataSource 
			 */
//			Class.forName("com.mysql.jdbc.Driver");
//		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "Health4All") ;
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
//			throw new RuntimeException();
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
		return null;
	}
	
	

	/*@Override
	public int getCircleCount() 
	
	{  
		
		String sql="select  COUNT(*)  FROM CIRCLE"; 
		
		jdbcTemplate.setDataSource(dataSource);
		return 	jdbcTemplate.execute(sql, action)(sql);
	}
*/
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}

	

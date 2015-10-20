package com.pvn.dao.jdbc.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pvn.model.Circle;

@Component
public class CircleDaoJDBCImpl
{
	@Autowired
	private DataSource dataSource;

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
}

	

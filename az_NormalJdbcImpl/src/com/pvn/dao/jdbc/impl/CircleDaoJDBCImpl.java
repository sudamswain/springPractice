package com.pvn.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pvn.dao.CircleDao;
import com.pvn.model.Circle;

public class CircleDaoJDBCImpl implements CircleDao
{
	@Override
	public Circle getCircle(int circleId) 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "Health4All") ;
		    PreparedStatement pstmt=con.prepareStatement("select * from circle where id= ?");
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
	
}

	

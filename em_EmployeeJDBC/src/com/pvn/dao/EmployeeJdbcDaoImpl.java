package com.pvn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.pvn.model.Employee;


public class EmployeeJdbcDaoImpl extends NamedParameterJdbcDaoSupport
{
	public List<Employee> getEmployeesList() {
		String sql="SELECT * FROM EMP";
		return this.getJdbcTemplate().query(sql, new EmployeeMapper());
	}
	
	public void insertEmployee(Employee emp)
	{
		String sql="INSERT INTO EMP (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES(?,?,?,?,CURDATE(),?,?,?)";
		int x = this.getJdbcTemplate().update(sql, new Object[]{emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getSal(),emp.getComm(),emp.getDeptno()});
		System.out.println(x+" rows affected");
	}
	
	public List<String> getAllJobs() 
	{
		String sql="SELECT DISTINCT JOB FROM EMP";
		return this.getJdbcTemplate().query(sql, new JobMapper());
	}
	
	public List<Map<String, Object>> getAllManagers() 
	{
		String sql="SELECT EMPNO,ENAME FROM EMP";
		return this.getJdbcTemplate().query(sql, new MgrMapper());
	}
	
	public List<String> getAllDepartmentts() 
	{
		String sql="SELECT DISTINCT DEPTNO FROM EMP ORDER BY DEPTNO";
		return this.getJdbcTemplate().query(sql, new DepartmentMapper());
	}
	
	public static class EmployeeMapper implements RowMapper<Employee>
	{
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			Employee employee=new Employee();
			employee.setEmpno(rs.getInt("empno"));
			employee.setEname(rs.getString("ename"));
			employee.setJob(rs.getString("job"));
			employee.setMgr(rs.getInt("mgr"));
			employee.setHiredate(rs.getString("hiredate"));
			employee.setSal(rs.getInt("sal"));
			employee.setComm(rs.getInt("comm"));
			employee.setDeptno(rs.getInt("deptno"));
			return employee;
		}
	}
	
	public static class JobMapper implements RowMapper<String>
	{
		@Override
		public String mapRow(ResultSet rs, int arg1) throws SQLException {
			return rs.getString("job");
		}
	}
	
	public static class MgrMapper implements RowMapper<Map<String, Object>>
	{
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			HashMap<String, Object> map=new HashMap<String, Object>(2);
			map.put("empno", rs.getInt("empno"));
			map.put("ename", rs.getString("ename"));
			return map;
		}
	}
	
	public static class DepartmentMapper implements RowMapper<String>
	{
		@Override
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("deptno");
		}
	}
}

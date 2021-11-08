package com.saif.appointment;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class AppointmentDBUtil {
	
	private DataSource dataSource;
	public AppointmentDBUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	public  void addAppointment(AppointmentBean bean) throws Exception {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
			myConn=dataSource.getConnection();
			String sql="insert into appointment "+"(full_name,age,DOB,blood_group,address,mobile,email,dateOfAppointment)"
			+"values(?,?,?,?,?,?,?,?)";
			
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, bean.getName());
			myStmt.setInt(2, bean.getAge());
			myStmt.setString(3, bean.getDOB());
			myStmt.setString(4, bean.getGroup());
			myStmt.setString(5, bean.getAddress());
			myStmt.setInt(6, bean.getMobile());
			myStmt.setString(7, bean.getEmail());
			myStmt.setString(8, bean.getDateOfAppointment());
			myStmt.execute();
		}
		finally{
			close(myConn,myStmt,null);
		}
		
		
	}
	public boolean getAppointment(AppointmentBean bean) throws Exception{
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		boolean flag=false;
		
		try {
			myConn=dataSource.getConnection();
			String sql ="select * from appointment";
			myStmt=myConn.createStatement();
			myRs= myStmt.executeQuery(sql);
			while(myRs.next()) {
				if(myRs.getString("dateOfAppointment").equals(bean.getDateOfAppointment())) {
					flag=true;
				}
				
			}
			
		}
		finally {
			close(myConn,myStmt,myRs);
		}
		return flag;
		
	}
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		try {
			if(myRs!=null) {
				myRs.close();
			}
			if(myConn!=null) {
				myConn.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}

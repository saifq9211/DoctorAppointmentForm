package com.saif.appointment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 * Servlet implementation class AppointmentControllerServlet
 */
@WebServlet("/AppointmentControllerServlet")
public class AppointmentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AppointmentDBUtil appointmentDBUtil;
	
	//definedatasource/connection pool for resource injection
	@Resource(name = "jdbc/doctor_appointment")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException{
		super.init();
		try {
			appointmentDBUtil=new AppointmentDBUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	
	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			addAppointment(request,response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	/*	Part filePart=req.getPart("file");
		String fileName=filePart.getSubmittedFileName();
		filePart.write("D:\\personal\\"+fileName);
		resp.getWriter().print("file is uploaded");*/
	}



	private void addAppointment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 String name=request.getParameter("name");
		 String age=request.getParameter("age");
		 String DOB=request.getParameter("DOB");
		 String group=request.getParameter("group");
		 String address=request.getParameter("address");
		 String mobile=request.getParameter("mobile");
		 String email=request.getParameter("email");
		 String dateOfAppointment=request.getParameter("dateOfAppointment");
		 AppointmentBean beans=new AppointmentBean(name,Integer.parseInt(age), DOB,group,address,Integer.parseInt(mobile),email,dateOfAppointment);
		 boolean flag= appointmentDBUtil.getAppointment(beans);
		 if(flag) {
			 out.println("Doctor is not available on "+dateOfAppointment);
			 
		 }else {
		 appointmentDBUtil.addAppointment(beans);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("Appointment.jsp");
			dispatcher.forward(request, response);
		 }
	}

}

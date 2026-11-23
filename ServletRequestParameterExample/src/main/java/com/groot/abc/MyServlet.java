package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		out.print("Welcome");
		String driverClass= config.getInitParameter("DriverClass");
		out.print("Driver Name : "+driverClass);
		String dbName= config.getInitParameter("dbname");
		out.print("<br/>Driver Name : "+dbName);
		ServletContext context=config.getServletContext();
		String dbUrl= context.getInitParameter("dburl");
		out.println("DB Url ="+dbUrl);
	}
}

package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUsingHTTP  extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("into the post");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("Name : "+req.getParameter("name"));
		out.print("Email : "+req.getParameter("email"));
		out.print("Password : "+req.getParameter("password"));
		out.print("Message : "+req.getParameter("message"));
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("into the get");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("Name : "+req.getParameter("name"));
		out.print("Email : "+req.getParameter("email"));
		out.print("Password : "+req.getParameter("password"));
		out.print("Message : "+req.getParameter("message"));
	}
}

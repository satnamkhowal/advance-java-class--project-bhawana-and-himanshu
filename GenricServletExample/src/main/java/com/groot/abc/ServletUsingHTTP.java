package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUsingHTTP extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("into the post");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("Name : " + req.getParameter("name"));
		out.print("Email : " + req.getParameter("email"));
		out.print("Password : " + req.getParameter("password"));
		out.print("Message : " + req.getParameter("message"));
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("into the get");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("Name : " + req.getParameter("name"));
		out.print("Email : " + req.getParameter("email"));
		out.print("Password : " + req.getParameter("password"));
		out.print("Message : " + req.getParameter("message"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/collage", "root", "root");
			System.out.println("Db Connection done ");
			PreparedStatement ps=conn.prepareStatement("insert into student (name,email,password,message) value(?,?,?,?)");
			ps.setString(1,req.getParameter("name"));
			ps.setString(2,req.getParameter("email"));
			ps.setString(3,req.getParameter("password"));
			ps.setString(4,req.getParameter("message"));
			int i=ps.executeUpdate();
			if(i>0) {
				out.print("<h5>record inserted<h5>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

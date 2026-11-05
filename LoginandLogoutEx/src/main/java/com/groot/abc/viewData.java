package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewData")
public class viewData extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("Welcome to the view data page");
		out.println("<table align='center'  width='500' border='1'>");//
		out.print("<tr>");
		out.print("<td>ID</td>");
		out.print("<td>Name</td>");
		out.print("<td>Email</td>");
		out.print("</tr>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/collage", "root", "root");
			System.out.println("Db Connection done ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet rs=null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student");
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				out.print("<tr>");
				out.print("<td>"+id+"</td>");
				out.print("<td>"+name+"</td>");
				out.print("<td>"+email+"</td>");
				out.print("</tr>");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<table>");
		/*
		 * 
		 * String name = req.getParameter("name"); String email =
		 * req.getParameter("email"); String p1 = req.getParameter("p1"); String p2 =
		 * req.getParameter("p2"); int i = 0; if (p1.equals(p2)) { try {
		 * 
		 * ps.setString(1, name); ps.setString(2, email); ps.setString(3, p1); i =
		 * ps.executeUpdate();
		 * 
		 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); } if
		 * (i > 0) { res.sendRedirect("login.html"); }else {
		 * res.sendRedirect("register.html?message=recored not inserted"); } }else {
		 * res.sendRedirect("register.html?Please checkk Password1 and password2"); }
		 */
	}
}

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

public class RegisterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String p1 = req.getParameter("p1");
		String p2 = req.getParameter("p2");
		int i = 0;
		if (p1.equals(p2)) {
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3366/collage", "root", "root");
				System.out.println("Db Connection done ");
				PreparedStatement ps = conn.prepareStatement("insert into register (name,email,password) value(?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, p1);
				i = ps.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if (i > 0) {
				res.sendRedirect("login.html");
			}else {
				res.sendRedirect("register.html?message=recored not inserted");
			}
		}else {
			res.sendRedirect("register.html?Please checkk Password1 and password2");
		}
	}
}

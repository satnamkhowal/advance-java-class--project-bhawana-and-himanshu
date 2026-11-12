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

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		int id=	Integer.valueOf(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			out.print("driver loaded");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("excection occured "+e.getMessage());
			e.printStackTrace();
		}
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3366/collage","root","root");
			out.print("Connection done");
		}catch (Exception e) {
			// TODO: handle exception
			out.print("excection occured "+e.getMessage());
			e.printStackTrace();
		}
		try {
			PreparedStatement ps= conn.prepareStatement("select * from register where id=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

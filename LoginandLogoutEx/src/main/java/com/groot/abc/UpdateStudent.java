package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String name=req.getParameter("n1");
		String email=req.getParameter("e1");
		int id=	Integer.valueOf(req.getParameter("id"));
		PrintWriter out=res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3366/collage","root","root");
		}catch (Exception e) {
			// TODO: handle exception
			out.print("excection occured "+e.getMessage());
			e.printStackTrace();
		}
		try {
			PreparedStatement ps= conn.prepareStatement("update student set name=?,email=? where id=?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, id);
			int i=ps.executeUpdate();
			if(i>0) {
				res.sendRedirect("./viewData");
			}
			
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

package com.groot.abc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletExample extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html>");
		out.print("<head>");
		
		out.print("</head>");
		out.print("<body>");
		String n=req.getParameter("name");
		String e=req.getParameter("email");
		String p=req.getParameter("password");
		String m=req.getParameter("message");
		out.print("Name : "+n);
		out.print("<br>Pasword : "+p);
		out.print("<br>Email : "+e);
		out.print("<br>messase : "+m);
		out.print("</body>");
		out.print("</html>");
	}

}


package com.myplatform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// Get email and password from login.html
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Check empty fields
		if (email == null || password == null || email.trim().isEmpty() || password.isEmpty()) {

			response.sendRedirect(request.getContextPath() + "/login.html?error=empty");

			return;
		}

		// SQL query
		String sql = "SELECT full_name, email, password " + "FROM register WHERE email = ?";

		try (Connection con = DBConnection.getConnection();

				PreparedStatement ps = con.prepareStatement(sql)) {

			// Set email
			ps.setString(1, email.trim().toLowerCase());

			// Execute query
			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					// Get hashed password from database
					String storedPassword = rs.getString("password");

					// Verify entered password
					boolean vali d = storedPassword != null && PasswordUtil.verifyPassword(password, storedPassword);

					HttpSession session = request.getSession();
					session.setAttribute("userEmail", rs.getString("email"));
					response.sendRedirect("./dash2");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

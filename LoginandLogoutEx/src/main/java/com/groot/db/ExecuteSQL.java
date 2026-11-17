package com.groot.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExecuteSQL
 */
@WebServlet("/ExecuteSQL")
public class ExecuteSQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteSQL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File file = new File("D:/collage_structure.sql");

		  String content = Files.readString(
	                Path.of("D:/collage_structure.sql")
	            );

	            String[] queries = content.split(";");
	            Connection conn= JDBCDBOPS.getConnection();
	            try (Statement stmt = conn.createStatement()) {

	                for (String query : queries) {

	                    query = query.trim();

	                    if (!query.isEmpty() && !query.startsWith("/*!")
	                            && !query.startsWith("--")
	                            && !query.startsWith("/*")) {

	                        stmt.execute(query);
	                    }
	                }
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            System.out.println("SQL executed successfully!");
	        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
